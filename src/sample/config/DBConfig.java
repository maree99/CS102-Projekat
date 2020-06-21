package sample.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    public static Connection connection = null;
    public static String url = "jdbc:mysql://localhost:3306";
    public static String username = "root";
    public static String password = "";
    public static String databaseName = "bike_rental";

    public static void openConection() throws SQLException {
        connection = DriverManager.getConnection(url + "/" + databaseName, username, password);
    }



}
