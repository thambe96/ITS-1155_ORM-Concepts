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
import javafx.scene.input.MouseEvent;

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


        String regex = "^dr\\.[A-Z][a-zA-Z]+$";
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        String inputName = txtTherapistName.getText();
        String inputEmail = txtTherapistEmail.getText();

        if (inputName.isEmpty() || inputEmail.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the details");
            alert.showAndWait();

            return;
        }

        if (!inputName.matches(regex)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid format in the name section");
            alert.showAndWait();
            return;
        }

        if (!inputEmail.matches(regexEmail)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid format in the email section");
            alert.showAndWait();
            return;

        }

        if (cmbAddProgram.getSelectionModel().getSelectedIndex() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select the program");
            alert.showAndWait();
            return;
        }






        TherapistDTO therapistDTO = new TherapistDTO();
        therapistDTO.setName(txtTherapistName.getText());
        therapistDTO.setEmail(txtTherapistEmail.getText());

        int programId = cmbAddProgram.getSelectionModel().getSelectedItem();
        therapistDTO.setId(programId);
        therapistBO.saveTherapist(therapistDTO);

        clearFields();

        loadTherapistDetailTable();




    }



    private void clearFields() {
        txtTherapistName.clear();
        txtTherapistEmail.clear();
        cmbAddProgram.getSelectionModel().clearSelection();
        lblTherapyProgramName.setText("");
        lblTherapistId.setText("");

    }



    @FXML
    void deleteTherapist(ActionEvent event) {


        int therapistId = Integer.parseInt(lblTherapistId.getId());

        therapistBO.deleteTherapist(therapistId);
        clearFields();
        loadTherapistDetailTable();

    }





    @FXML
    void resetTherapist(ActionEvent event) {
        clearFields();
    }






    @FXML
    void updateTherapist(ActionEvent event) {

//        TherapistTM therapistTM = tblTherapistDetail.getSelectionModel().getSelectedItem();
        TherapistDTO therapistDTO = new TherapistDTO();
        therapistDTO.setId(Integer.parseInt(lblTherapistId.getText()));
        therapistDTO.setName(txtTherapistName.getText());
        therapistDTO.setEmail(txtTherapistEmail.getText());

        therapistDTO.setTherapyProgramId(Integer.parseInt(cmbAddProgram.getValue().toString()));

        boolean flag = therapistBO.updateTherapist(therapistDTO);
        clearFields();
        loadTherapistDetailTable();



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

//        selectItemFromTable();






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

    public void selectItemFromTable() {

        TherapistTM therapistTM = tblTherapistDetail.getSelectionModel().getSelectedItem();
        lblTherapyProgramName.setText(therapistTM.getName());
        lblTherapistId.setText(String.valueOf(therapistTM.getId()));
        txtTherapistName.setText(therapistTM.getName());
        txtTherapistEmail.setText(therapistTM.getEmail());




    }

    @FXML
    void selectRow(MouseEvent event) {
        selectItemFromTable();
    }




















}
