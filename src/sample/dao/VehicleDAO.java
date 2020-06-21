package sample.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.config.DBConfig;
import sample.dto.VehicleDTO;
import sample.entity.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VehicleDAO implements CRUDService<Vehicle> {


    @Override
    public Vehicle save(Vehicle entity) throws SQLException {

        return null;
    }
    public static Vehicle findById(Integer id ) throws SQLException {
        DBConfig.openConection();
        PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("SELECT * FROM vehicle WHERE id = ?");
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        Vehicle vehicle = new Vehicle();
        while (rs.next()){
            vehicle.setId(rs.getInt(1));
        }

        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }

    public static ObservableList<VehicleDTO> getAllVehicleDTO() {
        ObservableList<VehicleDTO> vehicleList = FXCollections.observableArrayList();
        try {
            DBConfig.openConection();
            PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("select  vehicle.id, bb.title,bm.title,power,price_per_day\n" +
                    "from vehicle\n" +
                    "         join bike_model bm on vehicle.id_bike_model = bm.id\n" +
                    "         join bike_brand bb on bm.id_car_brand = bb.id;\n" +
                    "\n");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                VehicleDTO vehicle = new VehicleDTO();
                vehicle.setId(resultSet.getInt(1));
                vehicle.setBikeBrandTitle(resultSet.getString(2));
                vehicle.setBikeModelTitle(resultSet.getString(3));
                vehicle.setPower(resultSet.getDouble(4));
                vehicle.setPricePerDay(resultSet.getDouble(5));
                vehicleList.add(vehicle);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }


    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Vehicle update(Vehicle update) {
        return null;
    }

}

