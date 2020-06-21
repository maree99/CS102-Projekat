package sample.dao;

import sample.config.DBConfig;
import sample.entity.Reservation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReservationDAO implements CRUDService<Reservation> {

    @Override
    public Reservation save(Reservation entity) throws SQLException {
        DBConfig.openConection();
        PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("INSERT INTO reservation (start_date, end_date, total, id_client, id_vehicle) set VALUE (?,?,?,?,?)");
        preparedStatement.setString(1, entity.getStartDate());
        preparedStatement.setString(2, entity.getEndDate());
        preparedStatement.setDouble(3, entity.getTotal());
        preparedStatement.setInt(4, entity.getIdVehicle().getId());
        preparedStatement.setInt(5, entity.getIdClient().getId());
        preparedStatement.execute();

        return null;
    }

    @Override
    public List<Reservation> getAll() {
        return null;
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
