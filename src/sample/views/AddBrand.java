package sample.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.dao.BikeBrandDAO;
import sample.entity.BikeBrand;

import java.sql.SQLException;

public class AddBrand extends Application {
    BorderPane pane = new BorderPane();
    VBox vBox = new VBox();
    TextField brand = new TextField();
    Button add = new Button("Add");
    Text txt  = new Text("Insert Brand");

    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception{
        add.setPrefHeight(30);
        add.setPrefWidth(150);

        add.setOnAction(e->{
            BikeBrandDAO  bikeBrandDAO = new BikeBrandDAO();
            try {
                bikeBrandDAO.save(new BikeBrand(brand.getText()));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        vBox.getChildren().addAll(txt,brand,add);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10, 125, 0, 125));
        vBox.setSpacing(10);
        pane.setCenter(vBox);






        primaryStage.setTitle("Add Brand");
        primaryStage.setScene(new Scene(pane, 500, 250));
        primaryStage.show();

    }
}
