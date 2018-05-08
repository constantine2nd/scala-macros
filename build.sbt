name := "scala-macros"
organization := "com.github.constantine2nd"
version := "1.0.0"

scalaVersion in ThisBuild := "2.12.4"
run <<= run in Compile in core

lazy val macros = (project in file("macros")).settings(
 libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")) dependsOn macros
