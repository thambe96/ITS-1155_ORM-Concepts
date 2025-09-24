package edu.lk.ijse.gdse.orm.ormassignment.controller;

import edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapyProgramBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapyProgramDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.PatientTM;
import edu.lk.ijse.gdse.orm.ormassignment.dto.tm.TherapyProgramTM;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapyProgram;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

import static edu.lk.ijse.gdse.orm.ormassignment.bo.BOFactory.BOType.THERAPY_PROGRAM_BO;

public class TherapyProgramsController {


    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField duration;

    @FXML
    private TextField price;

    @FXML
    private TableView<TherapyProgramTM> tblProgram;


    TherapyProgramBO therapyProgramBO = (TherapyProgramBO) BOFactory.getBoFactory().getBO(THERAPY_PROGRAM_BO);

    public void initialize() {

        tblProgram.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("therapyProgramId"));
        tblProgram.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("therapyProgramName"));
        tblProgram.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblProgram.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));

//        loadAllTherapyPrograms();
    }



    @FXML
    void delete(ActionEvent event) {

        try {
            therapyProgramBO.deleteTherapyProgram(id.getText());
            refresh();
//            loadAllPatients();
            new Alert(Alert.AlertType.CONFIRMATION,"Program Deleted Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Program Deletion Not Successful!", ButtonType.OK).show();
        }



    }

    @FXML
    void reset(ActionEvent event) {
//        refresh();
    }

    @FXML
    void save(ActionEvent event) {


        String sid = id.getText();
        String sname = name.getText();
        String sduration = duration.getText();
        String sfee = price.getText();

        TherapyProgramDTO therapyProgramDTO = new TherapyProgramDTO();
        therapyProgramDTO.setTherapyProgramId(Integer.parseInt(sid));
        therapyProgramDTO.setTherapyProgramName(sname);
        therapyProgramDTO.setDuration(Integer.parseInt(sduration));
        therapyProgramDTO.setFee(Double.parseDouble(sfee));




        try {

            therapyProgramBO.saveTherapyProgram(therapyProgramDTO);

//            loadAllTherapyPrograms();
            new Alert(Alert.AlertType.CONFIRMATION,"Program Added Successful !", ButtonType.OK).show();


        } catch (Exception e) {


            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Program Added Not Successful!", ButtonType.OK).show();


        }





    }

    @FXML
    void update(ActionEvent event) {


        String sid = id.getText();
        String sname = name.getText();
        String sduration = duration.getText();
        String sfee = price.getText();


/*
        try {
            therapyProgramBO.updateTherapyProgram(new TherapyProgramDTO(sid, sname, Integer.parseInt(sduration), Double.parseDouble(sfee)));
            loadAllTherapyPrograms();
            new Alert(Alert.AlertType.CONFIRMATION,"Program Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Program Added Not Successful!", ButtonType.OK).show();
        }
        */




    }

    public void loadAllTherapyPrograms() {


    /*
        tblProgram.getItems().clear();

        ObservableList<TherapyProgramTM> programRows= (ObservableList<TherapyProgramTM>) tblProgram.getItems();

        try {

            List<TherapyProgramDTO> allPrograms = therapyProgramBO.getAllTherapyPrograms();

            for (TherapyProgramDTO therapyProgramDTO : allPrograms) {
                programRows.add(new TherapyProgramTM(

                        therapyProgramDTO.getTherapyProgramId(),
                        therapyProgramDTO.getTherapyProgramName(),
                        therapyProgramDTO.getDuration(),
                        therapyProgramDTO.getFee()
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */




    }


    @FXML
    void clickOn(MouseEvent event) {

  /*      TherapyProgramTM tm = (TherapyProgramTM) tblProgram.getSelectionModel().getSelectedItem();
        id.setText(tm.getTherapyProgramId());
        name.setText(tm.getTherapyProgramName());
        duration.setText(String.valueOf(tm.getDuration()));
        price.setText(String.valueOf(tm.getFee()));*/


    }


    public void refresh() {

/*
        id.setText(null);
        name.setText(null);
        duration.setText(null);
        price.setText(null);
        loadAllTherapyPrograms();
        */


    }








}
