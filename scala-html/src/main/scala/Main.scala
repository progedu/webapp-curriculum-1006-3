import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

object Main extends App {
  Application.launch(classOf[Main], args: _*)
}

class Main extends Application {
  override def start(stage: Stage): Unit = {
    stage.setTitle("ウエキチ　HTMLエディタ")
    stage.setWidth(650)
    stage.setHeight(300)
    val htmlEditor = new HTMLEditor()
    htmlEditor.setPrefHeight(245)
    val scene = new Scene(htmlEditor)
    stage.setScene(scene)
    stage.show()
  }
}

//  参考　https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/editor.htm#CHDBEGDD

//  public class HTMLEditorSample extends Application 
//      @Override
//      public void start(Stage stage) {
//         stage.setTitle("HTMLEditor Sample");
//          stage.setWidth(650650);
//          stage.setHeight(300);   
//          final HTMLEditor htmlEditor = new HTMLEditor();
//          htmlEditor.setPrefHeight(245);
//          Scene scene = new Scene(htmlEditor);       
//          stage.setScene(scene);
//          stage.show();
//      }
 
//      public static void main(String[] args) {
//          launch(args);
//      }
//  }