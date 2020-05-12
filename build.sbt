name := "webapp-curriculum-1006-3"

version := "0.1"

scalaVersion := "2.13.2"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

val osName: SettingKey[String] = SettingKey[String]("osName")

osName := (System.getProperty("os.name") match {
  case name if name.startsWith("Linux")   => "Linux"
  case name if name.startsWith("Mac")     => "mac"
  case name if name.startsWith("Windows") => "win"
  case _                                  => throw new Exception("Unknown platform!")
})

libraryDependencies ++= Seq(
  "org.openjfx" % "javafx-base" % "11-ea+25" classifier osName.value,
  "org.openjfx" % "javafx-controls" % "11-ea+25" classifier osName.value,
  "org.openjfx" % "javafx-fxml" % "11-ea+25" classifier osName.value,
  "org.openjfx" % "javafx-graphics" % "11-ea+25" classifier osName.value,
  "org.openjfx" % "javafx-web" % "11-ea+25" classifier osName.value,
  "org.openjfx" % "javafx-media" % "11-ea+25" classifier osName.value
)
