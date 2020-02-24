import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[HTMLEditorSample], args: _*)
}

class HTMLEditorSample extends Application {
  override def start(primaryStage: Stage): Unit = {

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)

    val scene = new Scene(htmlEditor, 650, 300)
    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}