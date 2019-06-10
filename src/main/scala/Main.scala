import javafx.application.application
import javafx.scene.Scene
import javafx.scene.seb.HTMLEditor
import javafx. stage.Stage

object Main entends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(rimaryStage: Stage): Unit = {
    primaryStage.setTiltle("HTMLEditor Sample")
    primaryStage.setWidth(650)
    primaryStage.setHeight(300)
    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    val scene = new Scene(htmlEditor)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

