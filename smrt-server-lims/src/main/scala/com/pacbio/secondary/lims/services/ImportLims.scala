package com.pacbio.secondary.lims.services

import java.io.{BufferedReader, StringReader}
import java.nio.file.{Files, Paths}

import com.pacbio.secondary.analysis.datasets.io.DataSetLoader
import com.pacbio.secondary.lims.LimsYml
import com.pacbio.secondary.lims.database.Database
import spray.http.MultipartFormData
import spray.routing.HttpService

import scala.collection.mutable
import scala.concurrent.Future
import scala.collection.JavaConverters._


/**
 * Imports all needed LIMS information for doing lookups and a resolution service
 *
 * This information currently comes from lims.yml and the related .subreaddata.xml file in found in
 * the same directory.
 */
trait ImportLims extends HttpService with LookupSubreadsetUuid {
  this: Database  =>

  implicit def executionContext = actorRefFactory.dispatcher

  val importLimsRoutes =
    // lims.yml files must be posted to the server
    pathPrefix("import") {
      post {
        entity(as[MultipartFormData]) {
          formData => {
            val uploadedFile = formData.fields.head.entity.data.toByteArray
            complete(
              Future(loadData(uploadedFile)))
          }
        }
      }
    }

  /**
   * Converts the YML to a Map.
   */
  def loadData(bytes: Array[Byte]): String = {
    val sr = new StringReader(new String(bytes))
    val br = new BufferedReader(sr)
    var l = br.readLine()
    val m = mutable.HashMap[String, String]()
    while (l != null) {
      val all = l.split(":[ ]+")
      val (k, v) = (all(0), all(1).stripPrefix("'").stripSuffix("'"))
      m.put(k, v)
      l = br.readLine()
    }

    // need the path in order to parse the UUID from .subreadset.xml
    m.get("path") match {
      case Some(p) => lookupUuid(p) match {
        case Some(uuid) => loadData(uuid, m)
        case None => s"No .subreadset.xml found. Skipping loading of $p"
      }
      case None => "No path in lims.yml file. Can't attempt UUID lookup"
    }
  }

  def loadData(uuid: String, m: mutable.HashMap[String, String]) : String = {
    setLimsYml(
      LimsYml(
        uuid = uuid,
        expcode = m.get("expcode").get.toInt,
        runcode = m.get("runcode").get,
        path = m.getOrElse("path", null),
        user = m.getOrElse("user", null),
        uid = m.getOrElse("uid", null),
        tracefile = m.getOrElse("tracefile", null),
        description = m.getOrElse("description", null),
        wellname = m.getOrElse("wellname", null),
        cellbarcode = m.getOrElse("cellbarcode", null),
        cellindex = m.get("cellindex").get.toInt,
        seqkitbarcode = m.getOrElse("seqkitbarcode", null),
        colnum = m.get("colnum").get.toInt,
        samplename = m.getOrElse("samplename", null),
        instid = m.get("instid").get.toInt)
    )
  }
}

/**
 * Trait required for abstracting the UUID file lookup for prod vs testing
 */
trait LookupSubreadsetUuid {
  def lookupUuid(path: String): Option[String]
}

trait FileLookupSubreadsetUuid {
  def lookupUuid(path: String): Option[String] = {
    val p = Paths.get(path.stripPrefix("file://"))
    val matches  =
      for (v <- Files.newDirectoryStream(p).asScala
           if v.toString.endsWith("subreadset.xml"))
        yield DataSetLoader.loadSubreadSet(v).getUniqueId
    matches.headOption
  }
}