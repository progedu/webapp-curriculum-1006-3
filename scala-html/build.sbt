scalaVersion := "2.12.7"

/*
*-deprecation は、今後廃止の予定の　API　を利用している時の警告が出力される
*-feature は、実験的な API 利用時の警告が出力される
*-unchecked は、型を利用したパターンマッチという機能が正しく動かない時に警告が出力される
*-Xlint は、望ましい書き方がされていない場合に警告が出力がされる
*/
scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

val osName: SettingKey[String] = SettingKey[String]("osName")

osName := (System.getProperty("os.name") match {
  case name if name.startsWith("Linux") => "linux"
  case name if name.startsWith("Mac") => "mac"
  case name if name.startsWith("Windows") => "win"
  case _ => throw new Exception("UNknown platform!")
})

libraryDependencies +=  "org.openjfx" % "javafx-base" % "11-ea+25" classifier osName.value
libraryDependencies +=  "org.openjfx" % "javafx-controls" % "11-ea+25" classifier osName.value
libraryDependencies +=  "org.openjfx" % "javafx-fxml" % "11-ea+25" classifier osName.value
libraryDependencies +=  "org.openjfx" % "javafx-graphics" % "11-ea+25" classifier osName.value
libraryDependencies +=  "org.openjfx" % "javafx-web" % "11-ea+25" classifier osName.value

assemblyMergeStrategy in assembly := {
  case PathList("module-info.class") => MergeStrategy.first
  case x => (assemblyMergeStrategy in assembly).value(x)
}