addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.10.0")

// Scoverage and Coveralls

resolvers += Resolver.sbtPluginRepo("snapshots")

// Do not update until sbt-scoverage 1.0 stabilizes!

addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "0.99.7.1")

addSbtPlugin("org.scoverage" %% "sbt-coveralls" % "0.99.0")
