import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.{ChoiceBox, TextField, Label, Button}
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[HTMLEditorSample], args: _*)
}

class HTMLEditorSample extends Application {
  override def start(primaryStage: Stage): Unit = {

    primaryStage.setTitle("Message Composing")
    primaryStage.show()
    val scene = new Scene(new Group())

    val root = new VBox()
    root.setPadding(new Insets(8, 8, 8, 8))
    root.setSpacing(5)
    root.setAlignment(Pos.BOTTOM_LEFT)

    val grid = new GridPane()
    grid.setVgap(5)
    grid.setHgap(10)

    val sendTo = new ChoiceBox(FXCollections.observableArrayList(
                      "To:", "Cc:", "Bcc:"))

    sendTo.setPrefWidth(100)
    GridPane.setConstraints(sendTo, 0, 0)
    grid.getChildren().add(sendTo)

    val tbTo = new TextField()
    tbTo.setPrefWidth(400)
    GridPane.setConstraints(tbTo, 1, 0)
    grid.getChildren().add(tbTo)

    val subjectLabel = new Label("Subject:")
    GridPane.setConstraints(subjectLabel, 0, 1)
    grid.getChildren().add(subjectLabel)

    val tbSubject = new TextField()
    tbSubject.setPrefWidth(400)
    GridPane.setConstraints(tbSubject, 1, 1)
    grid.getChildren().add(tbSubject)

    root.getChildren().add(grid)

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(370)

    root.getChildren().addAll(htmlEditor, new Button("Send"))

    val htmlLabel = new Label()
    htmlLabel.setWrapText(true)

    scene.setRoot(root)
    primaryStage.setScene(scene)
    primaryStage.show()

    val INITIAL_TEXT = "<html><body>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tortor felis, pulvinar in scelerisque cursus, pulvinar at ante. Nulla consequatcongue lectus in sodales. Nullam eu est a felis ornare bibendum et nec tellus. Vivamus non metus tempus augue auctor ornare. Duis pulvinar justo ac purus adipiscing pulvinar. Integer congue faucibus dapibus. Integer id nisl ut elit aliquam sagittis gravida eu dolor. Etiam sit amet ipsum sem.</body></html>"
    htmlEditor.setHtmlText(INITIAL_TEXT)
  }
}