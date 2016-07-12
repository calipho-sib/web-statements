name := """web-statements"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

fork in run := true

resolvers += "nexus" at "http://miniwatt:8800/nexus/content/groups/public/"

libraryDependencies ++= Seq(
  "com.oracle.jdbc" % "ojdbc7" % "12.1.0.2",
  "org.apache.jena" % "apache-jena-libs" % "3.0.1",
  "org.nextprot" % "nextprot-commons" % "0.9.0-SNAPSHOT",
  "org.nextprot.parsers" % "nextprot-parsers-bed" % "0.0.1-SNAPSHOT"
)