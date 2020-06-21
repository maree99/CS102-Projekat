package sample.dao;

import sample.entity.BikeModel;

import java.sql.SQLException;
import java.util.List;

public class BikeModelDAO implements CRUDService<BikeModel> {
    @Override
    public BikeModel save(BikeModel entity) throws SQLException {
        return null;
    }

    @Override
    public List<BikeModel> getAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public BikeModel update(BikeModel update) {
        return null;
    }

}
