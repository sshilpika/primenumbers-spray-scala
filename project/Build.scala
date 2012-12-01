import sbt._
import Keys._
import com.typesafe.sbt.SbtStartScript


object Build extends Build {
  import BuildSettings._
  import Dependencies._

  lazy val root = Project("primenumbers-spray-scala",file("."))
    .settings(SbtStartScript.startScriptForClassesSettings: _*)
    .settings(basicSettings: _*)
    .settings(libraryDependencies ++=
      provided(akkaActor) ++
      compile(sprayRouting, sprayCan) ++
      test(specs2, sprayTestkit) ++
      runtime(akkaSlf4j, logback)
    )
}