package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.PatientBO;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapyProgramBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapyProgramDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.util.ArrayList;
import java.util.List;

import static edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory.BOType.PATIENT_BO;
import static edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory.BOType.THERAPY_PROGRAM_BO;

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


    PatientBO patientBO = (PatientBO) BOFactory.getBoFactory().getBO(PATIENT_BO);
    TherapyProgramBO therapyProgramBO = (TherapyProgramBO) BOFactory.getBoFactory().getBO(THERAPY_PROGRAM_BO);


    public void initialize() {

        loadValuesToComboBox();

    }





    @FXML
    void addProgram(ActionEvent event) {



    }

    @FXML
    void resetProgramDetails(ActionEvent event) {

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
