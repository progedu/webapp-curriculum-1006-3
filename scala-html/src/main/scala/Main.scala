import javafx.application.Application
import javafx.scene.{Group, Node, Scene}
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App{
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application{

  override def start(primaryStage: Stage): Unit = {
   
    val htmleditor = new HTMLEditor
    htmleditor.setHtmlText( "<html><body>Lorem ipsum dolor sit " + "amet, consectetur adipiscing elit. Nam tortor felis, pulvinar "
    + "in scelerisque cursus, pulvinar at ante. Nulla consequat"
    + "congue lectus in sodales. Nullam eu est a felis ornare "
    + "bibendum et nec tellus. Vivamus non metus tempus augue auctor "
    + "ornare. Duis pulvinar justo ac purus adipiscing pulvinar. "
    + "Integer congue faucibus dapibus. Integer id nisl ut elit "
    + "aliquam sagittis gravida eu dolor. Etiam sit amet ipsum "
    + "sem.</body></html>")
    val scene = new Scene(htmleditor, 800, 600)
    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setScene(scene)
    primaryStage.show()
  }
  
}