

import BuildSettings._
// This an example of a simple project definition.
// It should build on both sbt 0.13.15 and sbt 1.0.0
lazy val root = (project in file("."))
  .settings(prestasacSettings: _*)
  .settings(
    organization in ThisBuild := "com.github.MercurieVV",
    scalaVersion in ThisBuild := "2.12.2",
    version in ThisBuild := "0.2.5",
    description in ThisBuild := "A Scala client library for the PrestaShop web services API",
    name := "prestasac",

    resolvers += "jitpack" at "https://jitpack.io",

    libraryDependencies += "com.github.MercurieVV" % "narcolepsy-scala" % "v0.2.7",
  )
/*
name := "prestashop_scalaxb"

version := "0.2.6"

scalaVersion := "2.12.4"*/