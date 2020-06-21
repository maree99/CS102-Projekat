package sample.dao;

import sample.config.DBConfig;
import sample.entity.User;
import sample.util.Crypto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements CRUDService<User> {

    @Override
    public User save(User entity) {
        System.out.println(entity.toString());
        entity.setPassword(Crypto.encrypt(entity.getPassword()));
        try {

            DBConfig.openConection();

            PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("insert into user(username,password,role,id_client) values (?,?,?,?)");
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setInt(3, entity.getRole().getId());
            preparedStatement.setInt(4, entity.getIdClient().getId());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public User update(User update) {
        return null;
    }


}
