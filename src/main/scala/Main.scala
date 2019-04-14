import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(stage: Stage) {
    stage.setTitle("HTML Editor")

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    
    val scene = new Scene(htmlEditor, 800, 600)
    stage.setScene(scene)
    stage.show()
  }
}