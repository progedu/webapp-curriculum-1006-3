import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control._
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.scene.web.HTMLEditor
import javafx.scene.web.WebEngine
import javafx.scene.web.WebView
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(stage: Stage) = {
    stage.setTitle("HTMLEditor Sample")
    stage.setWidth(650)
    stage.setHeight(300)
    val scene = new Scene(new Group())

    val root = new VBox()
    root.setPadding(new Insets(8, 8, 8, 8))
    root.setSpacing(5)
    root.setAlignment(Pos.BOTTOM_LEFT)

    val grid = new GridPane()
    grid.setVgap(5)
    grid.setHgap(10)

    val sendTo = new ChoiceBox(FXCollections.observableArrayList("TO:", "Cc:", "Bcc"))

    sendTo.setPrefWidth(100)
    GridPane.setConstraints(sendTo, 0, 0)
    grid.getChildren().add(sendTo)

    val tbTo = new TextField()
    tbTo.setPrefWidth(400)
    GridPane.setConstraints(tbTo, 1, 0)
    grid.getChildren().add(tbTo)

    val subjectLabel = new Label("Subject")
    GridPane.setConstraints(subjectLabel, 0, 1)
    grid.getChildren().add(subjectLabel)

    val toSubject = new TextField()
    toSubject.setPrefWidth(400)
    GridPane.setConstraints(toSubject, 1, 1)
    grid.getChildren().add(toSubject)

    root.getChildren().add(grid)

    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(370)
    val initialText = "<html><body>N予備校Scala基礎コース</body></html>"
    htmlEditor.setHtmlText(initialText)

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
    showHTMLButton.setOnAction(args0 => {
      webEngine.loadContent(htmlEditor.getHtmlText())
    })

    root.getChildren().addAll(htmlEditor, showHTMLButton, scrollPane)

    scene.setRoot(root)
    stage.setScene(scene)
    stage.show()
  }
}