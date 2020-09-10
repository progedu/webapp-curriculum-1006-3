// javaFX HTML Editor
// https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/editor.htm#CHDBEGDD
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
// public class HTMLEditorSample extends Application {

  override def start(stage: Stage): Unit = {
  //@Override
  //public void start(Stage stage) {
    stage.setTitle("HTMLEditor Sample")
    // stage.setWidth(650650)
    stage.setWidth(650)
    stage.setHeight(300)
    val htmlEditor = new HTMLEditor()
    // final HTMLEditor htmlEditor = new HTMLEditor();
    htmlEditor.setPrefHeight(245)
    val scene = new Scene(htmlEditor)
    // Scene scene = new Scene(htmlEditor);
    stage.setScene(scene)
    stage.show()
  }

  // public static void main(String[] args) {

  // }
}