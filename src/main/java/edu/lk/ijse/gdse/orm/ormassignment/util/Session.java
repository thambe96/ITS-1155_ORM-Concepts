package edu.lk.ijse.gdse.orm.ormassignment.util;

import edu.lk.ijse.gdse.orm.ormassignment.dto.UserDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.User;

public class Session {


    private static UserDTO loggedUser;

    public static void setLoggedUser(UserDTO userDTO) {
        loggedUser = userDTO;
    }

    public static UserDTO getLoggedUser() {
        return loggedUser;
    }

    public static void clear() {
        loggedUser = null;
    }



}
