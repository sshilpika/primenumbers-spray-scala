addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.10.0")

resolvers += Resolver.sbtPluginRepo("snapshots")

addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "0.99.11")

addSbtPlugin("org.scoverage" %% "sbt-coveralls" % "0.99.0")