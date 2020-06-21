package sample.dao;

import com.mysql.cj.xdevapi.DbDoc;
import sample.config.DBConfig;
import sample.entity.BikeBrand;
import sample.entity.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements CRUDService<Client> {

    @Override
    public Client save(Client entity) throws SQLException {
        try {
            DBConfig.openConection();
            PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("INSERT  into client(full_name,email,telephone) values (?,?,?)");
            preparedStatement.setString(1, entity.getFullName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getTelephone());

            preparedStatement.execute();

            PreparedStatement preparedStatement1 = DBConfig.connection.prepareStatement("select *\n" +
                    "from car_rental.client\n" +
                    "where id = (select max(id) from car_rental.client)");

            ResultSet resultSet = preparedStatement1.executeQuery();

            while (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConfig.connection.close();
        }
        return entity;
    }

    @Override
    public List<Client> getAll() {


        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Client update(Client update) {
        return null;
    }

    public static Client findById(Integer id) {
        Client client = new Client();
        try {
            DBConfig.openConection();

            PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("select * from client where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client.setId(resultSet.getInt(1));
                client.setFullName(resultSet.getString(2));
                client.setEmail(resultSet.getString(3));
                client.setTelephone(resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return client;
    }
}
