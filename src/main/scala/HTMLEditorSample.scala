import java.util.function.Consumer
import javafx.animation.{KeyFrame, KeyValue, Timeline}
import javafx.application.Application
import javafx.scene.{Group, Node, Scene}
import javafx.scene.paint.Color
import javafx.scene.shape.{Circle, StrokeType}
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage
import javafx.util.Duration
import java.lang.Math.random

object HTMLEditorSample extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {

  override def start(primaryStage: Stage): Unit = {

    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setWidth(650)
    primaryStage.setHeight(300)
    var htmlEditor: HTMLEditor  = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    var scene: Scene = new Scene(htmlEditor)
    primaryStage.setScene(scene)
    primaryStage.show()
  }

}