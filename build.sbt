import AssemblyKeys._

organization  := "edu.luc.etl"

version       := "0.0.2"

scalaVersion  := "2.10.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val scalazV = "7.0.5"
  val akkaV = "2.3.0"
  val sprayV = "1.3.1"
  val sprayJsonV = "1.2.5"
  val specs2V = "2.3.7"
  Seq(
    "org.scalaz"          %%  "scalaz-core"   % scalazV,
    "io.spray"            %   "spray-can"     % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-httpx"   % sprayV,
    "io.spray"            %%  "spray-json"    % sprayJsonV,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "io.spray"            %   "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % specs2V % "test"
  )
}

Revolver.settings

seq(com.typesafe.sbt.SbtStartScript.startScriptForClassesSettings: _*)

// The next few lines will work only with sbt-scoverage version 0.99.7.1.
// Do not update until sbt-scoverage 1.0 stabilizes!

instrumentSettings

ScoverageKeys.excludedPackages in ScoverageCompile := """.*\.Boot;.*\.PrimeNumberServiceActor"""

org.scoverage.coveralls.CoverallsPlugin.coverallsSettings

assemblySettings
