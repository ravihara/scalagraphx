name := "Simple GraphX App"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.apache.spark" %% "spark-graphx" % "1.6.1"
)
