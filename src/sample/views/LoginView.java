package sample.views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.dao.AuthDao;
import sample.entity.User;

import java.io.PrintWriter;

public class LoginView extends Application {
    BorderPane pane = new BorderPane();
    VBox vBox = new VBox();
    TextField username = new TextField();
    TextField password = new TextField();

    Button btn = new Button("Login");

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        username.setPromptText("Username");
        password.setPromptText("Password");
        btn.setPrefHeight(30);
        btn.setPrefWidth(150);


        vBox.getChildren().addAll(username, password, btn);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10, 125, 0, 125));
        vBox.setSpacing(15);


        pane.setCenter(vBox);

        btn.setOnAction(e -> {
            User user = new User(username.getText(), password.getText());
            try {
                User authUser = AuthDao.auth(user);

                if (authUser.getIdClient().getId() != null) {
                    Platform.runLater(() -> {
                        try {
                            new ClientPanel().start(new Stage());
                            primaryStage.close();
                            PrintWriter pw = new PrintWriter("log.txt");
                            pw.println(authUser.getIdClient().getId());
                            pw.close();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                } else if (authUser.getIdAdmin().getId() != null) {
                    Platform.runLater(() -> {
                        try {
                            new AdminView().start(new Stage());
                            primaryStage.close();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Input error");
                    alert.show();
                }
            } catch (Exception exception) {

            }
        });

        primaryStage.setTitle("Welcome");
        primaryStage.setScene(new Scene(pane, 600, 400));
        primaryStage.show();

    }
}
