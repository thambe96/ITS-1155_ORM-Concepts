package edu.lk.ijse.gdse.orm.ormassignment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UserManagementController {


    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    void handleLogin(ActionEvent event) throws IOException {

        if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the fields");
            alert.showAndWait();

        }

        if (txtUserName.getText().equals("username") && txtPassword.getText().equals("password")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home-page.fxml"));
            Parent dashboardRoot = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(dashboardRoot));
            stage.setTitle("The Serenity Mental Health");
        }




    }

}
