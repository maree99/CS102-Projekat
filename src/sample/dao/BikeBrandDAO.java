
package sample.dao;

import sample.config.DBConfig;
import sample.entity.BikeBrand;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeBrandDAO implements CRUDService<BikeBrand> {

    @Override
    public BikeBrand save(BikeBrand entity) throws SQLException {
        DBConfig.openConection();
        PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("insert into bike_brand(title) value (?)");
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.execute();
        DBConfig.connection.close();
        return null;
    }

    @Override
    public List<BikeBrand> getAll() {
        List<BikeBrand> bikeBrandList = new ArrayList<>();
        try {
            DBConfig.openConection();
            PreparedStatement preparedStatement = DBConfig.connection.prepareStatement("SELECT * FROM bike_brand");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BikeBrand bikeBrand = new BikeBrand();
                bikeBrand.setId(resultSet.getInt(1));
                bikeBrand.setTitle(resultSet.getString(2));

                bikeBrandList.add(bikeBrand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bikeBrandList;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public BikeBrand update(BikeBrand update) {
        return null;
    }


}
