package edu.lk.ijse.gdse.orm.ormassignment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomePageController {

    @FXML
    private AnchorPane ancStageHome;


    @FXML
    void navigateToPatientManagement(ActionEvent event) {

        String url = "/view/patient-management.fxml";
        loadPage(url);


    }

    @FXML
    void navigateToPayamentManagement(ActionEvent event) {
        String url = "/view/payement.fxml";
        loadPage(url);
    }

    @FXML
    void navigateToReportsManagement(ActionEvent event) {
        String url = "/view/register-details.fxml";
        loadPage(url);
    }

    @FXML
    void navigateToTherapistManagement(ActionEvent event) {
        String url = "/view/therapist-management.fxml";
        loadPage(url);
    }

    @FXML
    void navigateToTherapyProgramManagement(ActionEvent event) {

        String url = "/view/therapy-programs.fxml";
        loadPage(url);

    }

    @FXML
    void navigateToTherapySessionManagement(ActionEvent event) {

        String url = "/view/therapy-session-management.fxml";
        loadPage(url);

    }

    @FXML
    void navigateToUserManagement(ActionEvent event) {
        String url = "/view/user-management.fxml";
        loadPage(url);
    }



    public void loadPage(String path) {

        try {

            ancStageHome.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(path));

            load.prefWidthProperty().bind(ancStageHome.widthProperty());
            load.prefHeightProperty().bind(ancStageHome.heightProperty());


            ancStageHome.getChildren().add(load);


        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong while loading the page").show();

        }

    }





}