import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.{Group, Node, Scene}
import javafx.scene.control.ChoiceBox
import javafx.scene.control.TextField
import javafx.scene.control.Label
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object HTMLEditorSample extends App{
  Application.launch(classOf[HTMLEditorSample], args: _*)
}

class HTMLEditorSample extends Application{
  override def start(primaryStage:Stage): Unit = {
    val scene = new Scene(new Group(),650,500)

    primaryStage.setTitle("Message Composing")

    val root = new VBox
    root.setPadding(new Insets(8,8,8,8))
    root.setSpacing(5)
    root.setAlignment(Pos.BOTTOM_LEFT)

    val grid = new GridPane()
    grid.setVgap(5)
    grid.setHgap(10)

    val sendTo = new ChoiceBox(FXCollections.observableArrayList("To:", "Cc:", "Bcc:"))

    sendTo.setPrefWidth(100)
    GridPane.setConstraints(sendTo,0,0)
    root.getChildren().add(sendTo)

    val tbTo = new TextField()
    tbTo.setPrefWidth(400)
    GridPane.setConstraints(tbTo,1,0)
    root.getChildren().add(tbTo)

    val subjectLabel = new Label("Subject:")
    GridPane.setConstraints(subjectLabel, 0, 1)
    root.getChildren().add(subjectLabel)
        
    val tbSubject = new TextField()
    tbTo.setPrefWidth(400)
    GridPane.setConstraints(tbSubject, 1, 1)
    root.getChildren().add(tbSubject)

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(370)

    root.getChildren().addAll(htmlEditor, new Button("Send"))  

    val htmlLabel = new Label()
    htmlLabel.setWrapText(true)

    scene.setRoot(root)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}