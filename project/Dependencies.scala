import sbt._

object Dependencies {

  val logback = "ch.qos.logback" % "logback-classic" % Version.logback
  val scopt  = "com.github.scopt" %% "scopt" % "4.0.0"
  val logging = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.2" % "test"

  val serviceDependencies = List(
    logging,
    logback,
    scopt,
    scalaTest
  )

}

object Version {
  val logback = "1.2.3"
}

