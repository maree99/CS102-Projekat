package sample.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientView extends Application {
    BorderPane pane = new BorderPane();


    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(pane, 600, 400));
        primaryStage.show();
    }
}
