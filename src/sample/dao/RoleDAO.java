package sample.dao;

import sample.config.DBConfig;
import sample.entity.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDAO implements CRUDService<Role> {


    @Override
    public Role save(Role entity) throws SQLException {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Role update(Role update) {
        return null;
    }

    public static Role findById(Integer id) {
        Role role = new Role();
        try {
            DBConfig.openConection();

            PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("select * from role where id = ?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                role.setId(resultSet.getInt(1));
                role.setTitle(resultSet.getString(2));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return role;
    }
}
