import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(stage: Stage): Unit = {
    stage.setTitle("HTMLEditor")
    stage.setWidth(650)
    stage.setHeight(300)
    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    val scene = new Scene(htmlEditor)
    stage.setScene(scene)
    stage.show()
  }
}
