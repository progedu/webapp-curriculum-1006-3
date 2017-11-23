import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage
import scala.io.Source

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  val INITIAL_TEXT = """
  <!DOCTYPE html>
  <html lang="ja">
    <head>
      <meta charset=utf-8>
      <title>Sample</title>
    </head>
    <body>
      <h1>Sample HTML</h1>
      <hr/>
      <p>Sample</p>
    </body>
  </html>"""

  override def start(primaryStage: Stage): Unit = {
    val params = getParameters().getRaw()

    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setWidth(650)
    primaryStage.setHeight(400)

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)

    if (params.size() == 0) {
      htmlEditor.setHtmlText(INITIAL_TEXT)
    } else {
      htmlEditor.setHtmlText(readFile(params.get(0)))
    }

    val scene = new Scene(htmlEditor)
    primaryStage.setScene(scene)
    primaryStage.show()
  }

  def readFile(fileName: String): String = {
    val file = Source.fromFile(fileName)
    val lines = file.getLines
    var buffer = new StringBuffer()
    lines.foreach(buffer.append(_))
    file.close
    return buffer.toString()
  }
}