import Dependencies.serviceDependencies

name := "challenge-dotty"

version := "0.1"

scalaVersion := "2.13.5"
libraryDependencies ++= serviceDependencies

mainClass in assembly := Some("challenge.Main")
assemblyJarName in assembly := "challenge.jar"
