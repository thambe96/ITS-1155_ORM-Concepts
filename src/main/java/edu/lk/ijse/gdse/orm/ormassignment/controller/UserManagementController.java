package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.UserBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.UserDTO;
import edu.lk.ijse.gdse.orm.ormassignment.util.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class UserManagementController {


    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;


    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.USER_BO);


    @FXML
    void handleLogin(ActionEvent event) throws IOException {

        if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Please enter your username and password");
            alert.showAndWait();
            return;

        }


        UserDTO userDTO = userBO.getUser(txtUserName.getText());

        int userId = userDTO.getId();
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String role = userDTO.getRole();

        System.out.println(username);
        System.out.println(password);
        System.out.println(role);





/*

        if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the fields");
            alert.showAndWait();

        }

        */


        //txtUserName.getText().equals("username") && txtPassword.getText().equals("password")


        boolean flag1 = txtUserName.getText().equals(username);
        System.out.println("Flag 1 : " + flag1);
        System.out.println(txtUserName.getText());
        System.out.println(username);

        System.out.println();

        boolean flag2 = BCrypt.checkpw(txtPassword.getText(), password);
        System.out.println("Flag 2 : " + flag2);

        if ( flag1 && flag2) {

            //setting up Session

            Session.setLoggedUser(userDTO);

            System.out.println("Logged in!!!!");



            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home-page.fxml"));
            Parent dashboardRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(dashboardRoot));
            stage.setTitle("The Serenity Mental Health");


        }




    }

}
