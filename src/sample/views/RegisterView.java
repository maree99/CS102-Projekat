package sample.views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.dao.ClientDAO;
import sample.dao.UserDAO;
import sample.entity.Client;
import sample.entity.Role;
import sample.entity.User;

import java.sql.SQLException;

public class RegisterView extends Application {
    BorderPane pane = new BorderPane();
    VBox vBox = new VBox();

    TextField username = new TextField();
    TextField password = new TextField();

    TextField name = new TextField();
    TextField lastName = new TextField();
    TextField email = new TextField();
    TextField telephone = new TextField();
    Button btnRegister = new Button("Register ");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        name.setPromptText("Name");
        lastName.setPromptText("Last Name");
        email.setPromptText("Email");
        telephone.setPromptText("Telephone");
        btnRegister.setPrefHeight(30);
        btnRegister.setPrefWidth(150);
        username.setPromptText("Username");
        password.setPromptText("Password");

        vBox.getChildren().addAll(name, lastName, email, telephone, username, password, btnRegister);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10, 150, 0, 150));
        vBox.setSpacing(15);

        pane.setCenter(vBox);

        primaryStage.setTitle("Register");
        primaryStage.setScene(new Scene(pane, 600, 400));
        primaryStage.show();

//        Implementation

        btnRegister.setOnAction(e -> {

            UserDAO userDAO = new UserDAO();
            User user = new User();

            user.setUsername(username.getText());
            user.setPassword(password.getText());

            ClientDAO clientDAO = new ClientDAO();
            Client client = new Client();

            client.setFullName(name.getText() + " " + lastName.getText());
            client.setEmail(email.getText());
            client.setTelephone(telephone.getText());

            Role role = new Role(1);


            user.setRole(role);
            try {

                user.setIdClient(clientDAO.save(client));
                Platform.runLater(()->{
                    try {
                        new LoginView().start(new Stage());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    primaryStage.close();
                });

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            userDAO.save(user);


        });

    }


}
//bike.setOnAction(e->{
//        Platform.runLater(()->{
//        try {
//        new PanelBike().start(new Stage());
//        primaryStage.close();
//        } catch (Exception ex) {
//        ex.printStackTrace();
//        }
//
//        });
//        });
