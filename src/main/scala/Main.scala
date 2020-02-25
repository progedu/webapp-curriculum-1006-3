import javafx.application.Application
import javafx.event.{ActionEvent, EventHandler}
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.{TextArea, ScrollPane, Button}
import javafx.scene.layout.VBox
import javafx.scene.web.HTMLEditor
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

    val htmlCode = new TextArea()
    htmlCode.setWrapText(true)

    val scrollPane = new ScrollPane()
    scrollPane.getStyleClass().add("noborder-scroll-pane")
    scrollPane.setContent(htmlCode)
    scrollPane.setFitToWidth(true)
    scrollPane.setPrefHeight(180)

    val showHTMLButton = new Button("Produce HTML Code")
    root.setAlignment(Pos.CENTER)
    showHTMLButton.setOnAction(new EventHandler[ActionEvent] {
      override def handle(event: ActionEvent): Unit = {
        htmlCode.setText(htmlEditor.getHtmlText())
      }
    })

    root.getChildren().addAll(htmlEditor, showHTMLButton, scrollPane)
    scene.setRoot(root)

    stage.setScene(scene)
    stage.show()
  }
}