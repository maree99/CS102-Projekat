package sample.dao;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.config.DBConfig;
import sample.dto.ReservationDTO;
import sample.entity.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAO implements CRUDService<Reservation> {

    @Override
    public Reservation save(Reservation entity) throws SQLException {
        DBConfig.openConection();
        PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("INSERT INTO reservation (start_date, end_date, total, id_client, id_vehicle) values (?,?,?,?,?)");
        preparedStatement.setString(1, entity.getStartDate());
        preparedStatement.setString(2, entity.getEndDate());
        preparedStatement.setDouble(3, entity.getTotal());
        preparedStatement.setInt(5, entity.getIdVehicle().getId());
        preparedStatement.setInt(4, entity.getIdClient().getId());
        preparedStatement.execute();

        return null;
    }
    @Override
    public List<Reservation> getAll() {
        return null;
    }

public static ObservableList<ReservationDTO> getAllReservationDTO() {
    ObservableList<ReservationDTO> reservationList = FXCollections.observableArrayList();
    try {
        DBConfig.openConection();
        PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("select * from reservation join client c on reservation.id_client = c.id join bike_brand");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ReservationDTO reservation = new ReservationDTO();
            reservation.setId(resultSet.getInt(1));
            reservation.setStartDate(resultSet.getString(2));
            reservation.setEndDate(resultSet.getString(3));
            reservation.setClient(resultSet.getString(4));
            reservation.setBike(resultSet.getString(5));

            reservationList.add(reservation);


        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return reservationList;
}

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Reservation update(Reservation update) {
        return null;
    }

    public Reservation findById(Integer id) {
        return null;
    }
}
