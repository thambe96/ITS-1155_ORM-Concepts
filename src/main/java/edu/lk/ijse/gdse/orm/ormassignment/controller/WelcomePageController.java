package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.UserBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.mindrot.jbcrypt.BCrypt;

public class WelcomePageController {


    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;


    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.USER_BO);



    @FXML
    void addUser(ActionEvent event) {

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String role = "RECEPTIONIST";

        if (username.equals(null) || password.equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Please enter your username and password");
            alert.showAndWait();


            return;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());


        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(hashedPassword);
        userDTO.setRole(role);


        boolean flag = userBO.saveUser(userDTO);

        if (flag) {
            Alert.AlertType alertType = Alert.AlertType.INFORMATION;
            Alert alert = new Alert(alertType);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("User successfully created!");
            alert.showAndWait();
            clearFields();

        } else {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Something went wrong!");
            alert.showAndWait();

        }







    }

    @FXML
    void changePassword(ActionEvent event) {



        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String role = "RECEPTIONIST";

        if (username.equals(null) || password.equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Please enter your username and password");
            alert.showAndWait();


            return;
        }


        UserDTO userDTO = userBO.getUser(username);
        if (userDTO == null) {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("Error");
            alert.setHeaderText(username + " does not exist");
            alert.setContentText("User not found!");
            alert.showAndWait();
            return;
        }










        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        userDTO.setPassword(hashedPassword);



        boolean flag = userBO.updateUser(userDTO);

        if (flag) {
            Alert.AlertType alertType = Alert.AlertType.INFORMATION;
            Alert alert = new Alert(alertType);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("User password successfully Updated!");
            alert.showAndWait();
            clearFields();

        } else {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Something went wrong!");
            alert.showAndWait();

        }



    }





    @FXML
    void resetFields(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtUsername.clear();
        txtPassword.clear();
    }








}
