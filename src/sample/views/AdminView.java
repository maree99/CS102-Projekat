package sample.views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class AdminView extends Application {
    static Socket socket;
    static ObjectInputStream reader;
    static ObjectOutputStream writer;
    static Scanner input;



    BorderPane pane = new BorderPane();
    HBox hBox = new HBox();
    HBox hbNews = new HBox();
    Button panelBike = new Button("Panel Bike");
    Button panelClient = new Button("Panel Client");
    Button panelOrder = new Button("Panel Order");

    javafx.scene.control.Label news = new javafx.scene.control.Label();
    Document document;
    Elements elements;


    {
        try {
            document = Jsoup.connect("https://www.motorcyclenews.com/").get();
            elements = (Elements) document.select(".title > a");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
hBox.getChildren().addAll(panelBike,panelClient,panelOrder);
        hBox.setAlignment(Pos.CENTER);
hBox.setSpacing(10);

hbNews.getChildren().add(news);
hbNews.setAlignment(Pos.CENTER);

pane.setCenter(hBox);
pane.setBottom(hbNews);


        panelBike.setOnAction(e->{
            Platform.runLater(()->{
                try {
                    new PanelBike().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            });

        });

        panelClient.setOnAction(e->{
            Platform.runLater(()->{
                try {
                    new PanelClient().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            });

        });




        panelOrder.setOnAction(e->{
            Platform.runLater(()->{
                try {
                    new PanelOrder().start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            });

        });

        primaryStage.setTitle("Admin");
        primaryStage.setScene(new Scene(pane, 600, 400));
        primaryStage.show();


        new Thread(() -> {
            int i = 0;
            while (i<6) {

                String text = elements.get(i).text();
                i++;

                Platform.runLater(() -> {
                    news.setText(text);

                });
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void main(String[] args){
        launch(args);
    }
}


