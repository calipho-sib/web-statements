name := """web-statements"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

fork in run := true

resolvers += "nexus" at "http://miniwatt:8800/nexus/content/groups/public/"

libraryDependencies ++= Seq(
  "org.apache.jena" % "apache-jena-libs" % "3.0.1",
  "org.nextprot" % "nextprot-commons" % "2.1.0-SNAPSHOT",
  "org.nextprot.parser" % "nextprot-scala-parsers" % "1.1.0-SNAPSHOT"
)