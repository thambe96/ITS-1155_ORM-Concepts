package edu.lk.ijse.gdse.orm.ormassignment.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {

    public boolean save(T entity) throws Exception;
    public List<T> getAll() throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(String id)  throws Exception ;


}
