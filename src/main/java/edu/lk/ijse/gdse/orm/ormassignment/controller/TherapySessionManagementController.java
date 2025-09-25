package edu.lk.ijse.gdse.orm.ormassignment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class TherapySessionManagementController {



    @FXML
    private TableView<?> tblRegiDetails;

    @FXML
    private Label lblPatId;

    @FXML
    private Label lblPatName;

    @FXML
    private DatePicker shduleDate;

    @FXML
    private ComboBox<?> cmbTimePicker;

    @FXML
    private TableView<?> tblTherapistAvalability;

    @FXML
    void bookAppoinment(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }






}
