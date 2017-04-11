
package com.pacbio.simulator.scenarios

import java.net.URL
import java.nio.file.{Path, Paths}
import java.util.UUID
import java.io.{File, PrintWriter}

import scala.collection._

import akka.actor.ActorSystem
import com.typesafe.config.Config

import com.pacbio.secondary.analysis.constants.FileTypes
import com.pacbio.secondary.analysis.jobs.JobModels._
import com.pacbio.secondary.analysis.reports.ReportModels.Report
import com.pacbio.secondary.smrtlink.client.{SmrtLinkServiceAccessLayer, ClientUtils}
import com.pacbio.secondary.smrtlink.models._
import com.pacbio.simulator.{Scenario, ScenarioLoader}
import com.pacbio.simulator.steps._

object LargeMergeScenarioLoader extends ScenarioLoader {
  override def load(config: Option[Config])(implicit system: ActorSystem): Scenario = {
    require(config.isDefined, "Path to config file must be specified for LargeMergeScenario")
    val c: Config = config.get

    new LargeMergeScenario(getHost(c), getPort(c),
                           Paths.get(c.getString("datasetsPath")))
  }
}

class LargeMergeScenario(host: String, port: Int, datasetsPath: Path)
    extends Scenario
    with VarSteps
    with ConditionalSteps
    with IOSteps
    with SmrtLinkSteps
    with ClientUtils {

  override val name = "LargeMergeScenario"

  override val smrtLinkClient = new SmrtLinkServiceAccessLayer(host, port)

  val EXIT_SUCCESS: Var[Int] = Var(0)
  val EXIT_FAILURE: Var[Int] = Var(1)

  val dsFiles = listFilesByExtension(datasetsPath.toFile, ".subreadset.xml")
  val nFiles = dsFiles.size
  println(s"$nFiles SubreadSets found")
  val jobIds: Seq[Var[UUID]] = (0 until nFiles).map(_ => Var(UUID.randomUUID()))
  val dsIds: Seq[Var[Int]] = (0 until nFiles).map(_ => Var(0))
  val dsUUIDs: Seq[UUID] = (0 until nFiles).map(i => dsUuidFromPath(dsFiles(i).toPath))
  val jobId: Var[UUID] = Var()
  val jobStatus: Var[Int] = Var()
  val dataStore: Var[Seq[DataStoreServiceFile]] = Var()

  val ftSubreads = FileTypes.DS_SUBREADS.fileTypeId

  val setupSteps = Seq(
    jobStatus := GetStatus,
    fail("Can't get SMRT server status") IF jobStatus !=? EXIT_SUCCESS
  )
  val importSteps = (0 until nFiles).map(i => Seq(
      jobIds(i) := ImportDataSet(Var(dsFiles(i).toPath), Var(ftSubreads))
    )).flatMap(s => s) ++ (0 until nFiles).map(i => Seq(
      jobStatus := WaitForJob(jobIds(i)),
      fail(s"Import job $i failed") IF jobStatus !=? EXIT_SUCCESS,
      dataStore := GetImportJobDataStore(jobIds(i)),
      dsIds(i) := GetDataSetId(Var(dsUUIDs(i)))
    )).flatMap(s => s)
  val mergeSteps = Seq(
    jobId := MergeDataSetsMany(Var(ftSubreads), dsIds, Var("merge-subreads")),
    jobStatus := WaitForJob(jobId),
    fail("Merge job failed") IF jobStatus !=? EXIT_SUCCESS
  )
    
  override val steps = setupSteps ++ importSteps ++ mergeSteps
}
