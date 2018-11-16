import javafx.application.Application
import javafx.event.{ActionEvent, EventHandler}
import javafx.geometry.{Insets, Pos}
import javafx.scene.{Group, Scene}
import javafx.scene.control.{Button, ScrollPane, TextArea}
import javafx.scene.layout.VBox
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage


object Main extends App {
  Application.launch(classOf[Main], args: _*)
}
 
class Main extends Application {    
  val INITIAL_TEXT = "Write your html here" 
    
  override def start(stage: Stage): Unit = {
    stage.setTitle("HTMLEditor")
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