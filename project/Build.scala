import sbt._

import Keys._
import AndroidKeys._

object General {
  val settings = Defaults.defaultSettings ++ Seq (
    name := "ScalaAcademyAndroid",
    version := "0.1",
    versionCode := 0,
    scalaVersion := "2.9.3",
    platformName in Android := "android-19",
    javacOptions ++= Seq("-encoding", "UTF-8", "-source", "1.6", "-target", "1.6")
  )

  val proguardSettings = Seq (
    useProguard in Android := true
  )

  lazy val fullAndroidSettings =
    General.settings ++
    AndroidProject.androidSettings ++
    TypedResources.settings ++
    proguardSettings ++
    AndroidManifestGenerator.settings ++
    AndroidMarketPublish.settings ++ Seq (
      keyalias in Android := "change-me",
      libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"
    )
}

object AndroidBuild extends Build {
  lazy val main = Project (
    "ScalaAcademyAndroid",
    file("."),
    settings = General.fullAndroidSettings
  )
}
