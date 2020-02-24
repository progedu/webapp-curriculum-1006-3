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

    val INITIAL_TEXT = "<html><body>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tortor felis, pulvinar in scelerisque cursus, pulvinar at ante. Nulla consequatcongue lectus in sodales. Nullam eu est a felis ornare bibendum et nec tellus. Vivamus non metus tempus augue auctor ornare. Duis pulvinar justo ac purus adipiscing pulvinar. Integer congue faucibus dapibus. Integer id nisl ut elit aliquam sagittis gravida eu dolor. Etiam sit amet ipsum sem.</body></html>"
    htmlEditor.setHtmlText(INITIAL_TEXT)
  }
}