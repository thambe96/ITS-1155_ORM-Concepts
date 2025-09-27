package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.util.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {



    @FXML
    private Button btnUser;

    @FXML
    private Button btnPatient;

    @FXML
    private Button btnTherapist;

    @FXML
    private Button btnTherapyProgram;

    @FXML
    private Button btnAddTherapyProgram;

    @FXML
    private Button btnBookTherapySessions;

    @FXML
    private Button btnPayments;

    @FXML
    private Button btnLogout;
















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
        String url = "/view/welcome-page.fxml";
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

    public void initialize() {

        loadPage("/view/welcome-page.fxml");


        if (Session.getLoggedUser().getRole().equals("ADMIN")) {



            btnUser.setDisable(true);
            btnPatient.setDisable(true);
            btnAddTherapyProgram.setDisable(true);
            btnBookTherapySessions.setDisable(true);
            btnPayments.setDisable(true);



        }


        if (Session.getLoggedUser().getRole().equals("RECEPTIONIST")) {

            btnTherapyProgram.setDisable(true);
            btnTherapist.setDisable(true);



        }




    }




    @FXML
    void handleLogout(ActionEvent event) {

        Session.setLoggedUser(null);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user-management.fxml"));
        Parent dashboardRoot = null;
        try {
            dashboardRoot = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(dashboardRoot));
        stage.setTitle("The Serenity Mental Health");




    }





}