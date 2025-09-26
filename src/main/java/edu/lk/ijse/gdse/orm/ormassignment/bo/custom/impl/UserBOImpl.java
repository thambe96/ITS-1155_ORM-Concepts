package edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.UserBO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.UserDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.UserDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.User;
import org.modelmapper.ModelMapper;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public boolean saveUser(UserDTO userDTO) {

        boolean result = false;

        try {
            result = userDAO.save(modelMapper.map(userDTO, User.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return result;
    }

    @Override
    public UserDTO getUser(String username) {
        User user = userDAO.findByUsername(username);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(String.valueOf(user.getRole()));
        return userDTO;

    }

    @Override
    public boolean updateUser(UserDTO userDTO) {

        boolean flag = false;

        try {

            flag = userDAO.update(modelMapper.map(userDTO, User.class));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return flag;
    }

    @Override
    public UserDTO getUserByUsernameAndPassword(String username, String password) {

        User user = userDAO.findByUsernameByUserNameAndPassword(username, password);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(String.valueOf(user.getRole()));


        return userDTO;
    }


    public UserDTO getUserDTO() {
        return null;
    }



}
