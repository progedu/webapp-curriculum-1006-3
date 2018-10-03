scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

lazy val root = (project in file(".")).
  settings(
    unmanagedJars in Compile += {
        val ps = new sys.SystemProperties
        val jh = ps("java.home")
        Attributed.blank(file(jh) / "lib/ext/jfxrt.jar")
    }
  )