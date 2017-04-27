

initialCommands in (Test, console) := """ammonite.repl.Main.run("")"""

packSettings

packMain := Map(
  "fasta-to-reference" -> "com.pacbio.secondary.analysis.tools.FastaToReferenceApp",
  "fasta-to-gmap-reference" -> "com.pacbio.secondary.analysis.tools.FastaToGmapReferenceSetApp",
  "movie-metadata-to-dataset" -> "com.pacbio.secondary.analysis.tools.MovieMetaDataToDataSetApp",
  "movie-metadata-to-dataset-rtc" -> "com.pacbio.secondary.analysis.tools.MovieMetaDataToDataSetRtcApp",
  "validate-dataset" -> "com.pacbio.secondary.analysis.tools.ValidateDataSetApp",
  "merge-datasets" -> "com.pacbio.secondary.analysis.tools.DataSetMergerApp",
  "ds-tools" -> "com.pacbio.secondary.analysis.tools.PbDataSetToolsApp",
  "smrtflow-example-tool" -> "com.pacbio.secondary.analysis.tools.ExampleToolApp",
  "smrtflow-example-subparser-tool" -> "com.pacbio.secondary.analysis.tools.ExampleSubParserToolApp"
)

packGenerateWindowsBatFile := false
