package edu.lk.ijse.gdse.orm.ormassignment.dao.custom;

import edu.lk.ijse.gdse.orm.ormassignment.dao.CrudDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.User;

public interface UserDAO extends CrudDAO<User> {

    public User findByUsername(String username);
    public User findByUsernameByUserNameAndPassword(String username, String password);


}
