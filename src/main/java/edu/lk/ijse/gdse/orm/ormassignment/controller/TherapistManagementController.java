package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapistBO;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapyProgramBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapistDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapyProgramDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.PatientTM;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.TherapistTM;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

import static edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory.BOType.THERAPIST;
import static edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory.BOType.THERAPY_PROGRAM_BO;

public class TherapistManagementController {



    @FXML
    private Label lblTherapistId;

    @FXML
    private TextField txtTherapistName;

    @FXML
    private TextField txtTherapistEmail;


    @FXML
    private ComboBox<Integer> cmbAddProgram;

    @FXML
    private TableView<TherapistTM> tblTherapistDetail;

    @FXML
    private TableColumn<?, ?> colTherapistId;

    @FXML
    private TableColumn<?, ?> colTherapistName;

    @FXML
    private TableColumn<?, ?> colTherapistEmail;

    @FXML
    private TableColumn<?, ?> colTheraphyPrgId;

    @FXML
    private Label lblTherapyProgramName;



    TherapyProgramBO therapyProgramBO = (TherapyProgramBO) BOFactory.getBoFactory().getBO(THERAPY_PROGRAM_BO);
    TherapistBO therapistBO = (TherapistBO) BOFactory.getBoFactory().getBO(THERAPIST);




    @FXML
    void saveTherapist(ActionEvent event) {

        TherapistDTO therapistDTO = new TherapistDTO();
        therapistDTO.setName(txtTherapistName.getText());
        therapistDTO.setEmail(txtTherapistEmail.getText());

        int programId = cmbAddProgram.getSelectionModel().getSelectedItem();
        therapistDTO.setId(programId);
        therapistBO.saveTherapist(therapistDTO);

        loadTherapistDetailTable();




    }





    @FXML
    void deleteTherapist(ActionEvent event) {

    }





    @FXML
    void resetTherapist(ActionEvent event) {

    }






    @FXML
    void updateTherapist(ActionEvent event) {

    }





    private void loadTherapistTable() {

    }




    public void initialize() {

        loadValuesToTherapistComboBox();


        cmbAddProgram.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
//                System.out.println("New selected value: " + newVal);

                TherapyProgramDTO therapyProgramDTO = therapyProgramBO.getTherapyProgram(newVal);

                String programName = therapyProgramDTO.getTherapyProgramName();
                lblTherapyProgramName.setText(programName);


            }
        });




        //Table column initialitation

        tblTherapistDetail.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblTherapistDetail.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblTherapistDetail.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblTherapistDetail.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("therapyProgramId"));


        loadTherapistDetailTable();






    }




    private void loadValuesToTherapistComboBox() {


        List<TherapyProgramDTO> therapyProgramDTOS = therapyProgramBO.getAllTherapyPrograms();

        List<Integer> therapyProgramIds = new ArrayList<>();

        for (TherapyProgramDTO therapyProgramDTO : therapyProgramDTOS) {
            therapyProgramIds.add(therapyProgramDTO.getTherapyProgramId());
        }
        cmbAddProgram.getItems().setAll(therapyProgramIds);


    }



    private void loadTherapistDetailTable() {

        tblTherapistDetail.getItems().clear();
        ObservableList<TherapistTM> patientRows= (ObservableList<TherapistTM>) tblTherapistDetail.getItems();



        try {

            List<TherapistDTO> allTherapistDTOS = therapistBO.getTherapists();


            for (TherapistDTO therapistDTO : allTherapistDTOS) {
                TherapistTM therapistTM = new TherapistTM();
                therapistTM.setId(therapistDTO.getId());
                therapistTM.setName(therapistDTO.getName());
                therapistTM.setEmail(therapistDTO.getEmail());
                therapistTM.setTherapyProgramId(therapistDTO.getTherapyProgramId());
                patientRows.add(therapistTM);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }




















}
