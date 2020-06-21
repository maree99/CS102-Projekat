package sample.dao;

import sample.config.DBConfig;
import sample.entity.Admin;
import sample.entity.Client;
import sample.entity.Role;
import sample.entity.User;
import sample.util.Crypto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDao {
    public static User auth(User user) {
        User authUser = new User();
        try {

            System.out.println(user.getUsername() + " " + user.getPassword());
            DBConfig.openConection();
            PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("select id,username,password,id_client,id_admin,role from user where username = ?");
            preparedStatement.setString(1, user.getUsername());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (Crypto.decrypt(resultSet.getString(3)).equals(user.getPassword())) {
                    authUser.setId(resultSet.getInt(1));
                    authUser.setUsername(resultSet.getString(2));

                    authUser.setIdAdmin(new Admin(resultSet.getInt(5)));
                    authUser.setIdClient(ClientDAO.findById(resultSet.getInt(4)));
                    authUser.setRole(RoleDAO.findById(resultSet.getInt(6)));
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authUser;
    }
}
