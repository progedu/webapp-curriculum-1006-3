import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.{Group, Node, Scene}
import javafx.scene.control.ChoiceBox
import javafx.scene.control.TextField
import javafx.scene.control.Label
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.control.ScrollPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage
import javafx.event.EventHandler
import javafx.event.ActionEvent

object HTMLEditorControl extends App{
  Application.launch(classOf[HTMLEditorControl], args: _*)
}

class HTMLEditorControl extends Application{
  override def start(primaryStage:Stage) : Unit = {
    val str1 = "Lorem ipsum dolor sit "
    val str2 =  "amet, consectetur adipiscing elit. Nam tortor felis, pulvinar "
    val str3=  "in scelerisque cursus, pulvinar at ante. Nulla consequat"
    val str4 =  "bibendum et nec tellus. Vivamus non metus tempus augue auctor "
    val str5 =  "congue lectus in sodales. Nullam eu est a felis ornare "
    val str6 =  "ornare. Duis pulvinar justo ac purus adipiscing pulvinar. "
    val str7 =  "Integer congue faucibus dapibus. Integer id nisl ut elit "
    val str8 =  "aliquam sagittis gravida eu dolor. Etiam sit amet ipsum "
    val str9 =  "sem."
    val INITIAL_TEXT = str1+str2+str3+str4+str5+str6+str7+str8+str9
    
    primaryStage.setTitle("HTMLEditorControl")
    val scene = new Scene(new Group(),650,500)

    val root = new VBox
    root.setPadding(new Insets(8,8,8,8))
    root.setSpacing(5)
    root.setAlignment(Pos.BOTTOM_LEFT)

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(370)
    htmlEditor.setHtmlText(INITIAL_TEXT)

    val htmlCode = new TextArea()
    htmlCode.setWrapText(true)

    val scrollPane = new ScrollPane()
    scrollPane.getStyleClass().add("noborder-scroll-pane")
    scrollPane.setContent(htmlCode)
    scrollPane.setFitToWidth(true)
    scrollPane.setPrefHeight(180)

    val handler = new EventHandler[ActionEvent]{
      override def handle(t: ActionEvent) {
        htmlCode.setText(htmlEditor.getHtmlText())
      }
    }

    val showHTMLButton = new Button("Produce HTML Code")
    root.setAlignment(Pos.CENTER)
    showHTMLButton.setOnAction(handler)

    root.getChildren().addAll(htmlEditor,showHTMLButton,scrollPane)
    
    scene.setRoot(root)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}