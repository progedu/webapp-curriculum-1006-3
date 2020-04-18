import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setWidth(650)
    primaryStage.setHeight(300)
    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    val scene = new Scene(htmlEditor)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}
