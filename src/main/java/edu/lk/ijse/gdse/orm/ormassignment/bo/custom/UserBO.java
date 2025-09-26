package edu.lk.ijse.gdse.orm.ormassignment.bo.custom;

import edu.lk.ijse.gdse.orm.ormassignment.bo.SuperBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.UserDTO;

public interface UserBO extends SuperBO {

    public boolean saveUser(UserDTO userDTO);
    public UserDTO getUser(String username);
    public boolean updateUser(UserDTO userDTO);
    public UserDTO getUserByUsernameAndPassword(String username, String password);

}
