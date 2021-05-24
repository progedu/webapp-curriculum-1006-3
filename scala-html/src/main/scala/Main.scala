import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("HTMLEditor Sample")
    primaryStage.setWidth(1000)
    primaryStage.setHeight(850)
    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    val scene = new Scene(htmlEditor)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

/*
class Main extends Application {
  Override
  public void start(Stage stage) {
      stage.setTitle("HTMLEditor Sample");
      stage.setWidth(650650);
      stage.setHeight(300);   
      final HTMLEditor htmlEditor = new HTMLEditor();
      htmlEditor.setPrefHeight(245);
      Scene scene = new Scene(htmlEditor);       
      stage.setScene(scene);
      stage.show();
  }

  public static void main(String[] args) {
      launch(args);
  }
}*/