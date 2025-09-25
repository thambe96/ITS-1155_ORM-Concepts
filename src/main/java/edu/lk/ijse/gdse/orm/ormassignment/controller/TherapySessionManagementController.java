package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.PatientBO;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.RegisterDetailsBO;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapistBO;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapySessionBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.RegisterDetailsDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapistDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapySessionDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.RegisterDetailsTM;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.TherapistAvailabilityTM;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.TherapistTM;
import edu.lk.ijse.gdse.orm.ormassignment.entity.RegisterDetails;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class TherapySessionManagementController {



    @FXML
    private TableView<RegisterDetailsTM> tblRegiDetails;

    @FXML
    private Label lblPatId;

    @FXML
    private Label lblPatName;

    @FXML
    private DatePicker shduleDate;

    @FXML
    private ComboBox<String> cmbTimePicker;

    @FXML
    private TableView<TherapistAvailabilityTM> tblTherapistAvalability;


    @FXML
    private Label lblTherapistId;

    @FXML
    private Label lblTherapistName;


    private RegisterDetailsDTO registerDetailsDTO;

    private TherapySessionDTO therapySessionDTO;




    private int programId;


    RegisterDetailsBO registerDetailsBO = (RegisterDetailsBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.REGISTER_DETAILS_BO);
    PatientBO patientBO = (PatientBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.PATIENT_BO);
    TherapistBO therapistBO = (TherapistBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.THERAPIST);
    TherapySessionBO therapySessionBO = (TherapySessionBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.THERAPY_SESSION_BO);




    @FXML
    void bookAppoinment(ActionEvent event) {

        therapySessionDTO = new TherapySessionDTO();

        therapySessionDTO.setSheduledTime(getDateTime());
        therapySessionDTO.setPatientId(Integer.parseInt(lblPatId.getText()));
        therapySessionDTO.setTherapistId(Integer.parseInt(lblTherapistId.getText()));

        boolean flag = therapySessionBO.saveTherapySession(therapySessionDTO, registerDetailsDTO);

        if (flag) {

            loadRegDetailsTable();

            Alert.AlertType alertType = Alert.AlertType.CONFIRMATION;
            Alert alert = new Alert(alertType);
            alert.setContentText("Successful!");
            alert.show();
        } else {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setContentText("Something went wrong!");
            alert.show();

        }






    }








    @FXML
    void reset(ActionEvent event) {

    }


    public void initialize() {

        loadRegDetailsTable();
        loadTimeSlotsToComBox();
        tableClickEventHandler();
        initializePropValRegDetails();
        initializeProValTherapistAvailability();
        tableClickEventHandlerForAvailableTherapist();



    }





    private void loadRegDetailsTable() {

        tblRegiDetails.getItems().clear();
        ObservableList<RegisterDetailsTM> patientRows= (ObservableList<RegisterDetailsTM>) tblRegiDetails.getItems();


        try {

            List<RegisterDetailsDTO> registerDetailsDTOList =  registerDetailsBO.getRegisterDetails();

            for (RegisterDetailsDTO registerDetailsDTO : registerDetailsDTOList) {

                RegisterDetailsTM registerDetailsTM = new RegisterDetailsTM();

                registerDetailsTM.setRegisterDetailsId(registerDetailsDTO.getRegisterDetailsId());
                registerDetailsTM.setDate(registerDetailsDTO.getDate());
                registerDetailsTM.setNumberOfSessions(registerDetailsDTO.getNumberOfSessions());
                registerDetailsTM.setPatientId(registerDetailsDTO.getPatientId());
                registerDetailsTM.setTherapyProgramId(registerDetailsDTO.getTherapyProgramId());

                patientRows.add(registerDetailsTM);

            }






        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    private void loadTimeSlotsToComBox() {
        cmbTimePicker.getItems().addAll(
                "09:00 AM", "10:00 AM", "11:00 AM",
                "01:00 PM", "02:00 PM", "03:00 PM"
        );
    }





    public void tableClickEventHandler() {

        tblRegiDetails.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {

                RegisterDetailsTM selectedItem = tblRegiDetails.getSelectionModel().getSelectedItem();


                registerDetailsDTO = new RegisterDetailsDTO();

                registerDetailsDTO.setRegisterDetailsId(selectedItem.getRegisterDetailsId());
                registerDetailsDTO.setDate(selectedItem.getDate());
                registerDetailsDTO.setNumberOfSessions(selectedItem.getNumberOfSessions());
                registerDetailsDTO.setPatientId(selectedItem.getPatientId());
                registerDetailsDTO.setTherapyProgramId(selectedItem.getTherapyProgramId());





                programId = selectedItem.getTherapyProgramId(); // Therapy program id setup

                if (selectedItem != null) {


                    PatientDTO patientDTO = patientBO.getPatient(selectedItem.getPatientId());

                    int id = selectedItem.getRegisterDetailsId();
                    String name = patientDTO.getPatientName();

                    lblPatId.setText(String.valueOf(id));
                    lblPatName.setText(name);

//                    System.out.println(handleDataTime());



                }
            }
        });


    }


    private LocalDateTime getDateTime() {

        LocalDate date = shduleDate.getValue();
        String time = cmbTimePicker.getValue();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime localTime = LocalTime.parse(time, formatter);

        LocalDateTime dateTime = LocalDateTime.of(date, localTime);

        return dateTime;

    }


    @FXML
    void checkAvailability(ActionEvent event) {


        tblTherapistAvalability.getItems().clear();
        List<TherapistDTO> therapistDTOList = therapistBO.getAvailableTherapists(programId,getDateTime());


        ObservableList<TherapistAvailabilityTM> therapistRows= (ObservableList<TherapistAvailabilityTM>) tblTherapistAvalability.getItems();

        for (TherapistDTO therapistDTO : therapistDTOList) {
            TherapistAvailabilityTM therapistAvailabilityTM = new TherapistAvailabilityTM();
            therapistAvailabilityTM.setTherapistId(therapistDTO.getId());
            therapistAvailabilityTM.setTherapistName(therapistDTO.getName());
            therapistRows.add(therapistAvailabilityTM);

        }

//        System.out.println(therapistDTOList.size());

    }















    private void initializePropValRegDetails() {

        tblRegiDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("registerDetailsId"));
        tblRegiDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblRegiDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("numberOfSessions"));
        tblRegiDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("patientId"));
        tblRegiDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("therapyProgramId"));


    }


    private void initializeProValTherapistAvailability() {

        tblTherapistAvalability.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("therapistId"));
        tblTherapistAvalability.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("therapistName"));


    }


    public void tableClickEventHandlerForAvailableTherapist() {

        tblTherapistAvalability.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {

                TherapistAvailabilityTM therapistAvailabilityTM = tblTherapistAvalability.getSelectionModel().getSelectedItem();


                if (therapistAvailabilityTM != null) {


                    int therapistId = therapistAvailabilityTM.getTherapistId();
                    String therapistName = therapistAvailabilityTM.getTherapistName();


                    lblTherapistId.setText(String.valueOf(therapistId));
                    lblTherapistName.setText(therapistName);


                }

            }

        });

    }








}
