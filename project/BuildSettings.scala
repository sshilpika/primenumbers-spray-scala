import sbt._
import Keys._


object BuildSettings {
  val VERSION = "0.0.1"

  lazy val basicSettings = seq(
    version               := VERSION,
    homepage              := Some(new URL("http://laufer.cs.luc.edu/teaching/433")),
    organization          := "edu.luc.etl",
    organizationHomepage  := Some(new URL("http://etl.luc.edu")),
    description           := "Simple webservice to check whether a number is prime",
    startYear             := Some(2012),
    licenses              := Seq("MIT" -> new URL("http://opensource.org/licenses/MIT")),
    scalaVersion          := "2.9.2",
    resolvers             ++= Dependencies.resolutionRepos,
    scalacOptions         := Seq("-Ydependent-method-types", "-unchecked", "-deprecation", "-encoding", "utf8")
  )
}