import javafx.application.Application
import javafx.event.{ActionEvent, EventHandler}
import javafx.geometry.{Insets, Pos}
import javafx.scene.{Group, Scene}
import javafx.scene.control.{ScrollPane, Button}
import javafx.scene.layout.VBox
import javafx.scene.web.{HTMLEditor, WebView}
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[HTMLEditorSample], args: _*)
}

class HTMLEditorSample extends Application {
  val INITIAL_TEXT = """
      |Lorem ipsum dolor sit 
      |amet, consectetur adipiscing elit. Nam tortor felis, pulvinar 
      |congue lectus in sodales. Nullam eu est a felis ornare 
      |in scelerisque cursus, pulvinar at ante. Nulla consequat
      |bibendum et nec tellus. Vivamus non metus tempus augue auctor 
      |ornare. Duis pulvinar justo ac purus adipiscing pulvinar. 
      |Integer congue faucibus dapibus. Integer id nisl ut elit 
      |aliquam sagittis gravida eu dolor. Etiam sit amet ipsum 
      |sem.""".stripMargin

  override def start(stage: Stage): Unit = {

    stage.setTitle("HTMLEditor Sample")
    stage.setWidth(650)
    stage.setHeight(500)
    val scene = new Scene(new Group())

    val root = new VBox()
    root.setPadding(new Insets(8, 8, 8, 8))
    root.setSpacing(5)
    root.setAlignment(Pos.BOTTOM_LEFT)

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    htmlEditor.setHtmlText(INITIAL_TEXT)

    val browser = new WebView()
    val webEngine = browser.getEngine()

    val scrollPane = new ScrollPane()
    scrollPane.getStyleClass().add("noborder-scroll-pane")
    scrollPane.setStyle("-fx-background-color: white")
    scrollPane.setContent(browser)
    scrollPane.setFitToWidth(true)
    scrollPane.setPrefHeight(180)

    val showHTMLButton = new Button("Load Content in Browser")
    root.setAlignment(Pos.CENTER)
    showHTMLButton.setOnAction(new EventHandler[ActionEvent] {
      override def handle(event: ActionEvent): Unit = {
        webEngine.loadContent(htmlEditor.getHtmlText())
      }
    })

    root.getChildren().addAll(htmlEditor, showHTMLButton, scrollPane)
    scene.setRoot(root)

    stage.setScene(scene)
    stage.show()
  }
}