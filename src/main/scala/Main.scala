import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("HTML Editor N")
    primaryStage.setWidth(900)
    primaryStage.setHeight(700)
    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(650)
    val scene = new Scene(htmlEditor)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}