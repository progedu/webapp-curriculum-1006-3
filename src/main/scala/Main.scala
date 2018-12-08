import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {

    // メインウィンドウの設定
    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setWidth(650)
    primaryStage.setHeight(300)

    // HTMLEditorの作成
    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)

    // シーンの生成とHTMLEditorの配置
    val scene = new Scene(htmlEditor)

    // ステージにシーンを配置
    primaryStage.setScene(scene)

    // アプリケーションウィンドウの表示
    primaryStage.show()
  }
}