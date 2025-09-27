package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapySessionBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapySessionDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.PatientTM;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.TherapySessionTM;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;
import java.util.List;

public class PaymentController {

    @FXML
    private TableView<TherapySessionTM> tblSessionDetails;


    TherapySessionBO therapySessionBO = (TherapySessionBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.THERAPY_SESSION_BO);


    public void initialize() {

        tblSessionDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("therapySessionId"));
        tblSessionDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("sheduledTime"));
        tblSessionDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("patientId"));
        tblSessionDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("therapistId"));

        loadAllSessionDetails();



    }





    public void loadAllSessionDetails() {




        tblSessionDetails.getItems().clear();
        ObservableList<TherapySessionTM> SessionRows= (ObservableList<TherapySessionTM>) tblSessionDetails.getItems();
        try {

            List<TherapySessionDTO> sessionDTOS = therapySessionBO.getTherapySessions();


            for (TherapySessionDTO therapySessionDTO : sessionDTOS) {

                TherapySessionTM therapySessionTM = new TherapySessionTM();

                therapySessionTM.setTherapySessionId(therapySessionDTO.getTherapySessionId());
                therapySessionTM.setSheduledTime(therapySessionDTO.getSheduledTime());
                therapySessionTM.setPatientId(therapySessionDTO.getPatientId());
                therapySessionTM.setTherapistId(therapySessionDTO.getTherapistId());


                SessionRows.add(therapySessionTM);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }





    }



}
