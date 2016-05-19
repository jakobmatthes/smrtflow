package com.pacbio.logging

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.{Level, LoggerContext, PatternLayout}
import ch.qos.logback.classic.joran.JoranConfigurator
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.{FixedWindowRollingPolicy, RollingFileAppender, SizeBasedTriggeringPolicy}
import org.slf4j.LoggerFactory

import scala.collection.JavaConversions._

/**
  * Mixin for adding shared logger params to SMRT App classes
  *
  * See Readme.md for details about the shared parameters and examples of use.
  */
trait LoggerConfig {

  // params for logger configuration
  var logLevel = "ERROR"
  var logFile = "default_smrt.log"
  var logbackFile: String = null
  var debug = false

  // arbitrary formatting for console and log files
  val consolePattern = "%X{akkaTimestamp} %-5level[%thread] %logger{0} - %msg%n"
  val filePattern = "%date{yyyy-MM-dd} %X{akkaTimestamp} %-5level[%thread] %logger{1} - %msg%n"
  val fileRollingPosfix = ".%i.gz"

  // all the expected loggers
  val loggerNames = Set("akka", "Slf4jLogger", "scala.slick", "spray", "log1-Slf4jLogger")

  /**
    * Lazy updates the logger config
    *
    * @param logbackFile
    * @param logFile
    * @param debug
    * @param logLevel
    * @return
    */
  def configure(logbackFile: String,
                logFile: String,
                debug: Boolean,
                logLevel: String): LoggerConfig = {
    // ignore the default config
    LoggerOptions.configured = true
    // logback.xml trumps all other config
    if (logbackFile != this.logbackFile)
      setLogback(logbackFile)
    else {
      // order matters here so that debug can trump file and level is correctly set
      if (logFile != this.logFile) setFile(logFile)
      if (debug != this.debug) setDebug(debug)
      if (logLevel != this.logLevel) setLevel(logLevel)
    }
    return this
  }

  /**
    * Parses a logback.xml file and uses that as the SLFJ4 config.
    *
    * See http://logback.qos.ch/manual/configuration.html
    *
    * @param path File path of the logback.xml file
    * @return How many params were consumed
    */
  def setLogback(path: String) {
    val lc = LoggerFactory.getILoggerFactory().asInstanceOf[LoggerContext]
    val configurator = new JoranConfigurator()
    configurator.setContext(lc)
    // clear any old config
    lc.reset()
    // load the new logback.xml
    configurator.doConfigure(path)
  }

  /**
    * Sets the logging level for *all* registered loggers.
    *
    * @param level @see ch.qos.logback.classic.Level
    * @return How many params were consumed
    */
  def setLevel(level: String) {
    val lc = LoggerFactory.getILoggerFactory().asInstanceOf[LoggerContext]
    val l = Level.toLevel(level)
    for (logger <- lc.getLoggerList) { logger.setLevel(l) }
  }

  /**
    * Removes all handlers and directs logs to a file.
    *
    * @param file File path to save logging output
    * @return How many params were consumed
    */
  def setFile(file: String) {
    val lc = LoggerFactory.getILoggerFactory().asInstanceOf[LoggerContext]

    // configure the rolling file appender
    val appender = new RollingFileAppender[ILoggingEvent]();
    appender.setContext(lc)
    appender.setName("FILE")
    val patternEncoder = new PatternLayoutEncoder()
    patternEncoder.setPattern(filePattern)
    appender.setEncoder(patternEncoder)
    val patternLayout = new PatternLayout()
    patternLayout.setPattern(filePattern)
    patternLayout.setContext(lc)
    patternLayout.start()
    appender.setLayout(patternLayout)
    val rollingPolicy = new FixedWindowRollingPolicy()
    rollingPolicy.setParent(appender)
    rollingPolicy.setMinIndex(1)
    rollingPolicy.setMaxIndex(9)
    rollingPolicy.setFileNamePattern(file + fileRollingPosfix)
    appender.setRollingPolicy(rollingPolicy)
    val triggeringPolicy = new SizeBasedTriggeringPolicy[ILoggingEvent]()
    triggeringPolicy.setMaxFileSize("100MB")
    triggeringPolicy.start()
    appender.setTriggeringPolicy(triggeringPolicy)
    appender.setFile(file)
    appender.start()
    // set all loggers to direct output to the specified file
    for (logger <- lc.getLoggerList) {
      // remove any old appenders
      logger.detachAndStopAllAppenders()
      logger.addAppender(appender)
    }
  }

  /**
    * Sets all loggers to display information on System.out.
    *
    * Useful for debugging the code or piping output.
    *
    * @return How many params were consumed
    */
  def setDebug(debug: Boolean) {
    if (!debug) return
    val lc = LoggerFactory.getILoggerFactory().asInstanceOf[LoggerContext]
    // build up a SLFJ4 console logger
    val appender = new ConsoleAppender[ILoggingEvent]();
    appender.setContext(lc)
    appender.setName("STDOUT")
    val patternEncoder = new PatternLayoutEncoder()
    patternEncoder.setPattern(filePattern)
    appender.setEncoder(patternEncoder)
    val patternLayout = new PatternLayout()
    patternLayout.setPattern(filePattern)
    patternLayout.setContext(lc)
    patternLayout.start()
    appender.setLayout(patternLayout)
    appender.start()
    // set all loggers to direct output to console
    for (logger <- lc.getLoggerList) {
      // remove any old appenders
      logger.detachAndStopAllAppenders()
      // dump to console
      logger.addAppender(appender)
    }
  }
}