/*
 * Copyright (c) 2012 Orderly Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */

import sbt.{Def, _}
import Keys._

object BuildSettings {

  lazy val scalifySettings = Seq(sourceGenerators in Compile += Def.task {

    val file = (sourceManaged in Compile).value / "settings.scala"
    IO.write(file,
      """package co.orderly.prestasac.generated
  object Settings {
    val version = "%s"
    val name = "%s"
  }
"""
        .stripMargin
        .format(version, name)
    )
    Seq(file)
  }.taskValue)

  /*
    import ProguardPlugin._

    lazy val proguard = proguardSettings ++ Seq(
      proguardOptions := Seq(
        // keepMain("orderly.mdm.ApplicationBoot"),
        "-keepattributes *Annotation*,EnclosingMethod",
        "-dontskipnonpubliclibraryclassmembers",
        "-dontoptimize",
        "-dontshrink"
      )
    )
  */

  lazy val prestasacSettings = scalifySettings
}
