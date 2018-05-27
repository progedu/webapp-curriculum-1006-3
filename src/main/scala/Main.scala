import java.io.File
import java.nio.file.Files
import java.util.stream.{Collectors, Stream}

import javafx.application.{Application, Platform}
import javafx.geometry.{Insets, Pos}
import javafx.scene.Scene
import javafx.scene.control.{Button, ScrollPane, TextArea}
import javafx.scene.layout.{HBox, VBox}
import javafx.scene.web.{HTMLEditor, WebView}
import javafx.stage.{FileChooser, Stage}

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setWidth(640)
    primaryStage.setHeight(480)

    val base = new HBox()
    val root = new VBox()
    root.setPadding(new Insets(8, 8, 8, 8))
    root.setSpacing(5)
    root.setAlignment(Pos.CENTER)

    val htmlEditor = new HTMLEditor()
    htmlEditor.setStyle("-fx-border-color: brown; -fx-border-style: dotted; -fx-border-width: 2;")
    htmlEditor.setPrefHeight(245)

    // HTMLのソースコードを表示するテキストエリアを追加
    val htmlCode = new TextArea()
    //htmlCode.setWrapText(true)

    val scrollPane = new ScrollPane()
    scrollPane.getStyleClass.add("noborder-scroll-pane")
    scrollPane.setStyle("-fx-background-color: white")
    scrollPane.setFitToWidth(true)
    scrollPane.setPrefHeight(180)

    // 編集後のページを表示するWebViewを追加
    val viewer = new WebView()
    val engine = viewer.getEngine

    val buttons = new HBox()

    val button = new Button("Load Content in Browser")
    button.setOnAction(v => {
      val text = Stream.of(htmlEditor.getHtmlText, "").collect(Collectors.joining("\n"))

      engine.loadContent(text)
      htmlCode.setText(text)
      htmlEditor.setHtmlText(text)
    })

    var importFile: File = null

    val button2 = new Button("Load File")
    button2.setOnAction(v => {
      val fc = new FileChooser
      fc.setTitle("Load HTML File")
      fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("HTML", "*.html")
      )

      importFile = fc.showOpenDialog(primaryStage)

      Platform.runLater(() => {
        val result = Files.readAllLines(importFile.toPath)
        val text = result.stream().collect(Collectors.joining)
        htmlCode.setText(text)
        htmlEditor.setHtmlText(text)
      })
    })

    val scene = new Scene(base)

    buttons.getChildren.addAll(button, button2)
    root.getChildren.addAll(htmlEditor, buttons, htmlCode)
    base.getChildren.addAll(root, viewer)

    primaryStage.setScene(scene)
    primaryStage.show()
  }

}
