package sample.views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelClient extends Application {
    BorderPane pane = new BorderPane();
    HBox hBox = new HBox();
    VBox left = new VBox();
    VBox right = new VBox();
    HBox crud = new HBox();

    Button order = new Button("Order");
    Button bike = new Button("Bike");
    Button client = new Button("Client");

    Label fullName = new Label("Full Name");
    Label email = new Label("Email");
    Label telephone = new Label("Telephone");
    Label username = new Label("Username");
    Label password = new Label("Password");

    TextField tfFullName = new TextField();
    TextField tfEmail = new TextField();
    TextField tfTelephone = new TextField();
    TextField tfUsername = new TextField();
    TextField tfPassword = new TextField();

    Button save =  new Button("Save");


    TableView clientTableView = new TableView<>();

    TableColumn fullNameTC = new TableColumn("Full Name");
    TableColumn emailTC = new TableColumn("Email");
    TableColumn telephoneTC = new TableColumn("Telephone");
    TableColumn usernameTC = new TableColumn("Username");
    TableColumn passwordTC = new TableColumn("Password");

    Button edit = new Button("Edit");
    Button view = new Button("View");
    Button delete = new Button("Delete");



    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception{

        order.setPrefHeight(20);
        order.setPrefWidth(100);
        bike.setPrefHeight(20);
        bike.setPrefWidth(100);
        client.setPrefHeight(20);
        client.setPrefWidth(100);

        hBox.getChildren().addAll(order,bike,client);

        hBox.setPadding(new javafx.geometry.Insets(10,50,10,50));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        left.getChildren().addAll(fullName,tfFullName,email,tfEmail,telephone,tfTelephone,username,tfUsername,password,tfPassword,save);

        left.setPadding(new javafx.geometry.Insets(10,10,10,10));
        left.setSpacing(10);

        right.getChildren().addAll(clientTableView,crud);
        right.setPadding(new javafx.geometry.Insets(10,10,10,10));
        right.setSpacing(10);

        clientTableView.getColumns().addAll(fullNameTC, emailTC, telephoneTC, usernameTC,passwordTC);
        clientTableView.setPrefWidth(500);

        crud.getChildren().addAll(edit,view,delete);
        crud.setPadding(new javafx.geometry.Insets(10,10,10,10));
        crud.setSpacing(10);
        crud.setAlignment(Pos.CENTER_RIGHT);



        pane.setTop(hBox);
        pane.setLeft(left);
        pane.setCenter(right);


        primaryStage.setTitle("Admin Panel Client");
        primaryStage.setScene(new Scene(pane, 1000,750));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
