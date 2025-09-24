package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.PatientBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.PatientTM;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

import static edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory.BOType.PATIENT_BO;

public class PatientManagementController {


//    @FXML
//    private TextField id;

    @FXML
    private Label id;

    @FXML
    private TextField name;

    @FXML
    private TextField gender;

    @FXML
    private TextField age;

    @FXML
    private TextField address;

    @FXML
    private TextField email;


    @FXML
    private TableView<PatientTM> tblPatient;


    PatientBO patientBO = (PatientBO) BOFactory.getBoFactory().getBO(PATIENT_BO);


    public void initialize() {
        tblPatient.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("patientId"));
        tblPatient.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("patientName"));
        tblPatient.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("patientGender"));
        tblPatient.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("patientAge"));
        tblPatient.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
        tblPatient.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("patientEmail"));
        loadAllPatients();
        refresh();
    }



    @FXML
    void delete(ActionEvent event) {

        try {
            patientBO.deletePatient(id.getText());
            refresh();
//            loadAllPatients();
            new Alert(Alert.AlertType.CONFIRMATION,"Patient Deleted Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Patient Deletion Not Successful!", ButtonType.OK).show();
        }

    }

    @FXML
    void reset(ActionEvent event) {
        refresh();
    }

    @FXML
    void save(ActionEvent event) {

        String sid = id.getText();
        String sname = name.getText();
        String sgender = gender.getText();
        String sage = age.getText();
        String saddress = address.getText();
        String semail = email.getText();


        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatientId(Integer.parseInt(sid));
        patientDTO.setPatientName(sname);
        patientDTO.setPatientGender(sgender);
        patientDTO.setPatientAge(Integer.parseInt(sage));
        patientDTO.setPatientAddress(saddress);
        patientDTO.setPatientEmail(semail);


        try {


            patientBO.savePatient(patientDTO);
//            loadAllPatients();
//            refresh();
            new Alert(Alert.AlertType.CONFIRMATION,"Patient Added Successful !", ButtonType.OK).show();



        } catch (Exception e) {


            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Patient Added Not Successful!", ButtonType.OK).show();


        }






    }

    @FXML
    void update(ActionEvent event) {

        String sid = id.getText();
        String sname = name.getText();
        String sgender = gender.getText();
        String sage = age.getText();
        String saddress = address.getText();
        String semail = email.getText();


/*
        try {
            patientBO.updatePatient(new PatientDTO(sid, sname, sgender, Integer.parseInt(sage), saddress, semail));
            loadAllPatients();
            refresh();
            new Alert(Alert.AlertType.CONFIRMATION,"Patient Updated Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Updation Patient was Not Successful!", ButtonType.OK).show();
        }


        */



    }



    public void loadAllPatients() {



/*
        tblPatient.getItems().clear();
        ObservableList<PatientTM> patientRows= (ObservableList<PatientTM>) tblPatient.getItems();
        try {

            List<PatientDTO> allPatients = patientBO.getAllPatients();


            for (PatientDTO patientDTO : allPatients) {
                patientRows.add(new PatientTM(

                        patientDTO.getPatientId(),
                        patientDTO.getPatientName(),
                        patientDTO.getPatientGender(),
                        patientDTO.getPatientAge(),
                        patientDTO.getPatientAddress(),
                        patientDTO.getPatientEmail())
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        */



    }



    @FXML
    void clickOn(MouseEvent event) {


     /*
        PatientTM tm = (PatientTM) tblPatient.getSelectionModel().getSelectedItem();
        id.setText(tm.getPatientId());
        name.setText(tm.getPatientName());
        gender.setText(tm.getPatientGender());
        age.setText(String.valueOf(tm.getPatientAge()));
        address.setText(tm.getPatientAddress());
        email.setText(tm.getPatientEmail());

        */


    }

    public void refresh() {


//        id.setText(null);

//        String nextId = ""; /*patientBO.getNextPatientId();*/


/*
        id.setText(nextId);

        name.setText(null);
        gender.setText(null);
        age.setText(null);
        address.setText(null);
        email.setText(null);
        loadAllPatients();
        */


    }






}
