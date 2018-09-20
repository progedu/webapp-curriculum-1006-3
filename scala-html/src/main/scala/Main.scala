import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
 
    override def start(stage: Stage):Unit =   {
        stage.setTitle("HTMLEditor Sample");
        stage.setWidth(650);
        stage.setHeight(300);   
        var htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        var scene = new Scene(htmlEditor);       
        stage.setScene(scene);
        stage.show();
    }
 
}