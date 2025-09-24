package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.PatientBO;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.RegisterDetailsBO;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapyProgramBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.RegisterDetailsDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapyProgramDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory.BOType.*;

public class RegisterDetailsController {



    @FXML
    private ComboBox<Integer> cmbPatientId;

    @FXML
    private ComboBox<Integer> cmbPrgId;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button btnAddProgram;

    @FXML
    private Button btnRestAddPrg;

    @FXML
    private Label lblPatientName;

    @FXML
    private Label lblProgName;

    @FXML
    private Label lblTreatmentCost;


    PatientBO patientBO = (PatientBO) BOFactory.getBoFactory().getBO(PATIENT_BO);
    TherapyProgramBO therapyProgramBO = (TherapyProgramBO) BOFactory.getBoFactory().getBO(THERAPY_PROGRAM_BO);
    RegisterDetailsBO registerDetailsBO =  (RegisterDetailsBO) BOFactory.getBoFactory().getBO(REGISTER_DETAILS_BO);

    private int numberOfSessions;

    public void initialize() {

          cmbPrgId.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                System.out.println("New selected value: " + newVal);

                TherapyProgramDTO therapyProgramDTO = therapyProgramBO.getTherapyProgram(newVal);

                String programName = therapyProgramDTO.getTherapyProgramName();
                String programCost = String.valueOf(therapyProgramDTO.getFee());
                numberOfSessions = therapyProgramDTO.getDuration();


                lblProgName.setText(programName);
                lblTreatmentCost.setText(programCost);



            }
        });

        cmbPatientId.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                System.out.println("New selected value: " + newVal);

                String patientName = patientBO.getPatient(newVal).getPatientName();

                lblPatientName.setText(patientName);


            }
        });



        loadValuesToComboBox();

    }





    @FXML
    void addProgram(ActionEvent event) throws Exception {

        if (cmbPatientId.getValue() == null) {

            Alert.AlertType alertType = Alert.AlertType.WARNING;
            Alert alert = new Alert(alertType);
            alert.setTitle("Warning");
            alert.setHeaderText("Error:: ");
            alert.setContentText("Please select a patient!!");
            alert.showAndWait();

            return;

        }


        if (cmbPrgId.getValue() == null) {
            Alert.AlertType alertType = Alert.AlertType.WARNING;
            Alert alert = new Alert(alertType);
            alert.setTitle("Warning");
            alert.setHeaderText("Error:: ");
            alert.setContentText("Please select a program!!");
            alert.showAndWait();
            return;

        }



        String id = String.valueOf(cmbPatientId.getValue());
        String prgId = String.valueOf(cmbPrgId.getValue());
//        String date = String.valueOf(datePicker.getValue());

        LocalDate localDate = datePicker.getValue();
        Date date = java.sql.Date.valueOf(localDate);
        System.out.println(date);


        RegisterDetailsDTO registerDetailsDTO = new RegisterDetailsDTO();
        registerDetailsDTO.setPatientId(Integer.parseInt(id));
        registerDetailsDTO.setTherapyProgramId(Integer.parseInt(prgId));
        registerDetailsDTO.setDate(date);
        registerDetailsDTO.setNumberOfSessions(numberOfSessions);

        boolean results = registerDetailsBO.saveRegisterDetails(registerDetailsDTO);

        if (results) {
            Alert.AlertType alertType = Alert.AlertType.INFORMATION;
            Alert alert = new Alert(alertType);
            alert.setTitle("Success");
            alert.setHeaderText("Success!");
            alert.setContentText("Success!");
            alert.showAndWait();

        }






    }

    @FXML
    void resetProgramDetails(ActionEvent event) {


        cmbPatientId.getSelectionModel().clearSelection();
        cmbPrgId.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        lblPatientName.setText("");
        lblProgName.setText("");
        lblTreatmentCost.setText("");


    }


    private void loadValuesToComboBox() {

        List<PatientDTO> patientDTOS = patientBO.getAllPatients();
        List<TherapyProgramDTO> therapyProgramDTOS = therapyProgramBO.getAllTherapyPrograms();

        List<Integer> patientIds = new ArrayList<>();
        List<Integer> therapyProgramIds = new ArrayList<>();

        for (PatientDTO patientDTO : patientDTOS) {
            patientIds.add(patientDTO.getPatientId());
        }

        for (TherapyProgramDTO therapyProgramDTO : therapyProgramDTOS) {
            therapyProgramIds.add(therapyProgramDTO.getTherapyProgramId());
        }

        cmbPatientId.getItems().setAll(patientIds);
        cmbPrgId.getItems().setAll(therapyProgramIds);


    }

















}
