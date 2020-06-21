package sample.views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelOrder extends Application {
    BorderPane pane = new BorderPane();
    HBox hBox = new HBox();
    VBox center = new VBox();
    HBox crud = new HBox();

    Button order = new Button("Order");
    Button bike = new Button("Bike");
    Button client = new Button("Client");


    TableView rezervationTableView = new TableView<>();

    TableColumn startTC = new TableColumn("Start Date");
    TableColumn endTC = new TableColumn("End Date");
    TableColumn clientTC = new TableColumn("Client");
    TableColumn bikeTC = new TableColumn("Bike");

    Button edit = new Button("Edit");
    Button view = new Button("View");
    Button delete = new Button("Delete");

    public static void start(String[] args){launch(args);}

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

        center.getChildren().addAll(rezervationTableView,crud);
        center.setPadding(new javafx.geometry.Insets(10,10,10,10));
        center.setSpacing(10);

        rezervationTableView.getColumns().addAll(startTC, endTC, clientTC, bikeTC);
        rezervationTableView.setPrefWidth(500);

        crud.getChildren().addAll(edit,view,delete);
        crud.setPadding(new javafx.geometry.Insets(10,10,10,10));
        crud.setSpacing(10);
        crud.setAlignment(Pos.CENTER_RIGHT);


        pane.setTop(hBox);
        pane.setCenter(center);

        bike.setOnAction(e->{
            Platform.runLater(()->{
                try {
                    new PanelBike().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            });
        });

        order.setOnAction(e->{
            Platform.runLater(()->{

                try {
                    new PanelOrder().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });


        });

        client.setOnAction(e->{
            Platform.runLater(()->{

                try {
                    new ClientPanel().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });


        });




        primaryStage.setTitle("Admin Panel Order");
        primaryStage.setScene(new Scene(pane,1000,750));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
