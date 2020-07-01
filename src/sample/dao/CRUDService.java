package sample.dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUDService<T> {

    public T save(T entity) throws SQLException;

    public List<T> getAll() throws SQLException;

    public void deleteById(Integer id);

    public T update(T update);

}
