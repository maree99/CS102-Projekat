package sample.views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.dao.BikeBrandDAO;
import sample.dao.VehicleDAO;
import sample.dto.VehicleDTO;
import sample.entity.BikeBrand;


import java.util.List;

public class PanelBike extends Application {

    BorderPane pane = new BorderPane();
    HBox hBox = new HBox();
    VBox left = new VBox();
    VBox right = new VBox();
    HBox crud = new HBox();
    ComboBox cb = new ComboBox<>();



    Button order = new Button("Order");
    Button bike = new Button("Bike");
    Button client = new Button("Client");

    Label brand = new Label("Brand");
    Label model = new Label("Model");
    Label yaer = new Label("Fuel");
    Label registration = new Label("Registration");


    TextField tfModel = new TextField();
    TextField tfYear = new TextField();
    TextField tfRegistration = new TextField();

    Button save =  new Button("Save");


    TableView bikeTableView = new TableView<>();

    TableColumn brandTC = new TableColumn("Brand");
    TableColumn modelTC = new TableColumn("Model");
    TableColumn yearTC = new TableColumn("Year");
    TableColumn registrationTC = new TableColumn("Registration");

    Button edit = new Button("Edit");
    Button view = new Button("View");
    Button delete = new Button("Delete");
    Button btBrand = new Button("Add Brand");






    public static void main(String[] args) {launch(args);}


    @Override
    public void start(Stage primaryStage) throws Exception{
        order.setPrefHeight(20);
        order.setPrefWidth(100);
        bike.setPrefHeight(20);
        bike.setPrefWidth(100);
        client.setPrefHeight(20);
        client.setPrefWidth(100);
        cb.setPrefWidth(150);


        hBox.getChildren().addAll(order,bike,client);

        hBox.setPadding(new javafx.geometry.Insets(10,50,10,50));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        left.getChildren().addAll(brand,cb,model,tfModel,yaer,tfYear,registration,tfRegistration,save);

        left.setPadding(new javafx.geometry.Insets(10,10,10,10));
        left.setSpacing(10);

        right.getChildren().addAll(bikeTableView,crud);
        right.setPadding(new javafx.geometry.Insets(10,10,10,10));
        right.setSpacing(10);

        bikeTableView.getColumns().addAll(brandTC, modelTC, yearTC, registrationTC);
        bikeTableView.setPrefWidth(500);


        ObservableList<VehicleDTO> vehicleDTOList = VehicleDAO.getAllVehicleDTO();
        bikeTableView.setItems(vehicleDTOList);

        brandTC.setCellValueFactory(new PropertyValueFactory<>("bikeBrandTitle"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("bikeModelTitle"));
        yearTC.setCellValueFactory(new PropertyValueFactory<>("power"));
        registrationTC.setCellValueFactory(new PropertyValueFactory<>("pricePerDay"));


        crud.getChildren().addAll(btBrand,edit,view,delete);
        crud.setPadding(new javafx.geometry.Insets(10,10,10,10));
        crud.setSpacing(10);
        crud.setAlignment(Pos.CENTER_RIGHT);

        pane.setTop(hBox);
        pane.setLeft(left);
        pane.setCenter(right);

        btBrand.setOnAction(e->{
            Platform.runLater(()->{

                try {
                    new AddBrand().start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });

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


        BikeBrandDAO bikeBrandDAO = new BikeBrandDAO();
        List<BikeBrand> carBrandList = bikeBrandDAO.getAll();
        ObservableList items = FXCollections.observableArrayList(carBrandList);

        cb.setItems(items);

        primaryStage.setTitle("Admin Panel Bike");
        primaryStage.setScene(new Scene(pane, 1000,750));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
