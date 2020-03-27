import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage

object Main extends App{
    Application.launch(classOf[htmleditor],args:_*)
}

class htmleditor extends Application{
     override def start (primaryStage:Stage):Unit={
        primaryStage.setTitle("HTMLEditor")
        primaryStage.setWidth(650650)
        primaryStage.setHeight(300)

        val htmlEditor=new HTMLEditor()
        htmlEditor.setPrefHeight(245)
        val scene =new Scene(htmlEditor)
        primaryStage.setScene(scene)
        primaryStage.show()
    }
}