#!/usr/bin/env python
"""

Template taken from: https://github.com/PacificBiosciences/pbcommand/blob/master/pbcommand/cli/examples/template_simple.py
"""

import os
import sys
import logging
import multiprocessing
import time
import uuid as U
from pbcommand.cli import get_default_argparser_with_base_opts, \
    pacbio_args_runner

from pbcommand.engine import run_cmd, ExtCmdResult
from pbcommand.services import ServiceAccessLayer
from pbcommand.utils import setup_log

log = logging.getLogger(__name__)

__version__ = "0.1.0"


def _run_cmd(cmd):
    x = run_cmd(cmd, sys.stdout, sys.stderr)
    if x.exit_code != 0:
        log.error(x)
    return x


FUNCS = {}


def register(f):
    FUNCS[f.__name__] = f
    return f


def runner(args, **kwargs):
    fname = args[0]
    f = FUNCS[fname]
    log.debug("Running {f} {a} {k}".format(f=f, a=args[1:], k=kwargs))
    return f(*args[1:], **kwargs)


@register
def get_status(host, port):
    return _run_cmd("pbservice status --host={h} --port={p}".format(h=host, p=port))


@register
def import_dataset(host, port, path):
    return _run_cmd("pbservice import-dataset --host={h} --port={p} {x}".format(h=host, p=port, x=path))


@register
def run_analysis(host, port, path):
    return _run_cmd("pbservice run-analysis --host={h} --port={p} --block {x}".format(h=host, p=port, x=path))


def _process_original_dataset(path, output_dir_prefix):
    # copy to new output dir
    # change the UUID
    basename = os.path.basename(path)
    x = U.uuid4()

    output_dir = os.path.join(output_dir_prefix, "dataset-{x}".format(x=x))
    os.mkdir(output_dir)

    cmd = "dataset copyto {i} {o}".format(i=path, o=output_dir)
    x = _run_cmd(cmd)
    log.info(x)

    dataset_xml = os.path.join(output_dir, basename)
    x = _run_cmd("dataset newuuid {i}".format(i=dataset_xml))
    log.info(x)

    return dataset_xml


def _generate_data(host, port, dataset_path, analysis_json, output_dir_prefix, ntimes):
    for x in xrange(ntimes):
        yield "get_status", host, port
        yield "import_dataset", host, port, _process_original_dataset(dataset_path, output_dir_prefix)
        yield "get_status", host, port
        yield "run_analysis", host, port, analysis_json


def get_parser():

    p = get_default_argparser_with_base_opts(__version__, "Stress Tool")
    f = p.add_argument
    f('--host', default="localhost", help="Host name")
    f('--port', default=8070, type=int, help="Port")
    f('--nprocesses', default=10, type=int, help="Number of worker processes to launch")
    # FIXME this naming is terrible
    f('-x', default=5, type=int, help="Total number of tasks will be ~ 3 x")
    return p


def run_main(host, port, nprocesses, ntimes):
    logging.basicConfig(level=logging.DEBUG, file=sys.stdout)

    print FUNCS.keys()

    chunksize = 6

    info = "{h}:{p} with ntimes:{n} with processors:{x}".format(h=host, p=port, n=ntimes, x=nprocesses)

    # FIXME. All paths are relative to smrtflow root
    def to_p(rpath):
        return os.path.join(os.getcwd(), rpath)

    # DataSet
    dataset_path = to_p("test-data/smrtserver-testdata/ds-references/mk-01/mk_name_01/referenceset.xml")

    # Dev Diagnostic
    analysis_json = to_p("smrt-server-analysis/src/test/resources/analysis-dev-diagnostic-01.json")

    output_dir_prefix = to_p("test-output")
    if not os.path.exists(output_dir_prefix):
        os.mkdir(output_dir_prefix)

    xs = _generate_data(host, port, dataset_path, analysis_json, output_dir_prefix, ntimes)

    log.info("Starting {i}".format(i=info))

    p = multiprocessing.Pool(nprocesses)

    results = p.map(runner, xs, chunksize=chunksize)

    failed = [r for r in results if r.exit_code != 0]
    for f in failed:
        log.error(f)

    log.debug("exiting {i}".format(i=info))
    log.error("Failed Results {r} of {x}".format(r=len(failed), x=len(results)))
    return 0


def args_runner(args):
    return run_main(args.host, args.port, args.nprocesses, args.x)


def main(argv):
    return pacbio_args_runner(argv[1:],
                              get_parser(),
                              args_runner,
                              log,
                              setup_log_func=setup_log)


if __name__ == '__main__':
    sys.exit(main(sys.argv))