package com.pacbio.secondary.analysis.engine

import java.nio.file.Path
import java.util.UUID

import com.pacbio.secondary.analysis.jobs.{AnalysisJobStates, CoreJob}
import com.pacbio.secondary.analysis.jobs.JobModels.{DataStoreFile, JobResult, RunnableJob, ImportAble}

object CommonMessages {

  // New Job model
  case class RunJob(job: CoreJob, path: Path)

  // Add a new Job
  case class AddNewJob(job: CoreJob)

  case class UpdateJobCompletedResult(result: JobResult)

  // General Successful message. Intended to be used in DAO layer
  case class SuccessMessage(message: String)

  // General Failed Message
  case class FailedMessage(message: String)

  case object HasNextRunnableJobWithId

  case object CheckForRunnableJob

  case object AllJobsCompleted

  case class UpdateJobStatus(uuid: UUID, state: AnalysisJobStates.JobStates)

  // Update the resolved jobOptions directory
  case class UpdateJobOutputDir(uuid: UUID, path: Path)

  case class GetAllJobs(limit: Int)

  case object GetSystemJobSummary

  case class GetJobStatusByUUID(uuid: UUID)
  case class GetJobStatusById(i: Int)

  // DataSet Related Messages
  case class PacBioImportDataSet(datum: ImportAble, jobId: UUID)
  case class ImportDataStoreFile(dataStoreFile: DataStoreFile, jobUUID: UUID)
  case class ImportDataStoreFileByJobId(dataStoreFile: DataStoreFile, jobId: Int)

}
