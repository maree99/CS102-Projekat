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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.config.DBConfig;
import sample.dao.ReservationDAO;
import sample.dao.VehicleDAO;
import sample.dto.VehicleDTO;
import sample.entity.Client;
import sample.entity.Reservation;
import sample.entity.Vehicle;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ClientPanel extends Application {
    BorderPane pane = new BorderPane();
    HBox hBox = new HBox();
    HBox menu = new HBox();
    Label totalPrice = new Label();
    VBox vBox = new VBox();
    DatePicker startDate = new DatePicker();
    DatePicker endDate = new DatePicker();

    Text txt = new Text("Ukupan iznos");
    TextField ukupanIznos = new TextField();

    TableView<VehicleDTO> bikeTableView = new TableView<VehicleDTO>();

    TableColumn brandTC = new TableColumn("Brand");
    TableColumn modelTC = new TableColumn("Model");
    TableColumn yearTC = new TableColumn("Year");
    TableColumn registrationTC = new TableColumn("Registration");
    Button news = new Button("News");

    Button countPriceBtn = new Button("Izracunaj cenu");
    Button order = new Button("Order");
    Button bikeB = new Button("Bike");
    Button client = new Button("Client");
    Button rezervisi = new Button("Rezervisi");
    Button izracunajCenu = new Button("Izracunaj cenu");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        order.setPrefHeight(20);
        order.setPrefWidth(100);
        bikeB.setPrefHeight(20);
        bikeB.setPrefWidth(100);
        client.setPrefHeight(20);
        client.setPrefWidth(100);


        hBox.getChildren().addAll(startDate, endDate);
        hBox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        hBox.setSpacing(10);

        vBox.getChildren().addAll(txt, ukupanIznos, bikeTableView, rezervisi,izracunajCenu);
        vBox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        vBox.setSpacing(10);



        bikeTableView.getColumns().addAll(brandTC, modelTC, yearTC, registrationTC);
        bikeTableView.setPrefWidth(500);

        ObservableList<VehicleDTO> vehicleDTOList = VehicleDAO.getAllVehicleDTO();
        bikeTableView.setItems(vehicleDTOList);



        brandTC.setCellValueFactory(new PropertyValueFactory<>("bikeBrandTitle"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("bikeModelTitle"));
        yearTC.setCellValueFactory(new PropertyValueFactory<>("power"));
        registrationTC.setCellValueFactory(new PropertyValueFactory<>("pricePerDay"));

        pane.setTop(hBox);
        pane.setLeft(vBox);

        izracunajCenu.setOnAction(e -> {
            try {
                double total = ChronoUnit.DAYS.between(new SimpleDateFormat("yyyy-mm-dd").parse(startDate.getValue().toString()).toInstant(), new SimpleDateFormat("yyyy-mm-dd").parse(endDate.getValue().toString()).toInstant())
                        * bikeTableView.getSelectionModel().getSelectedItem().getPricePerDay();

                ukupanIznos.setText(String.valueOf(total));

            } catch (ParseException ex) {
                ex.printStackTrace();
            }


        });

        rezervisi.setOnAction(e -> {
            ReservationDAO reservationDAO = new ReservationDAO();
            Reservation reservation = new Reservation();
            VehicleDAO vehicleDAO = new VehicleDAO();

            reservation.setStartDate(startDate.getValue().toString());
            reservation.setEndDate(endDate.getValue().toString());
            try {
                reservation.setIdVehicle(VehicleDAO.findById(bikeTableView.getSelectionModel().getSelectedItem().getId()));
        reservation.setTotal(ChronoUnit.DAYS.between(new SimpleDateFormat("yyyy-mm-dd").parse(startDate.getValue().toString()).toInstant(), new SimpleDateFormat("yyyy-mm-dd").parse(endDate.getValue().toString()).toInstant())
                * bikeTableView.getSelectionModel().getSelectedItem().getPricePerDay());

        BufferedReader bufferedReader = null;
        String line = "";
        File file;
        bufferedReader = new BufferedReader(new FileReader("log.txt"));
        while ((line = bufferedReader.readLine())!= null ) {
            reservation.setIdClient(new Client(Integer.valueOf(line)));

        }
        reservationDAO.save(reservation);

            } catch (SQLException | ParseException | FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        });

        bikeB.setOnAction(e -> {
            Platform.runLater(() -> {
                try {
                    new PanelBike().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            });
        });

        order.setOnAction(e -> {
            Platform.runLater(() -> {

                try {
                    new PanelOrder().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });


        });

        client.setOnAction(e -> {
            Platform.runLater(() -> {

                try {
                    new ClientPanel().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });


        });

        countPriceBtn.setOnAction(e -> {
            Double price = bikeTableView.getSelectionModel().getSelectedItem().getPricePerDay();
            totalPrice.setText(String.valueOf(price));
        });
        primaryStage.setTitle("Client Panel");
        primaryStage.setScene(new Scene(pane, 1000, 750));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}
