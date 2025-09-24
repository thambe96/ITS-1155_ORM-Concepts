package edu.lk.ijse.gdse.orm.ormassignment.dto;

import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapyProgram;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class RegisterDetailsDTO {


    private int registerDetailsId;
    private Date date;
    private int numberOfSessions;
    private Patient patient;
    private TherapyProgram therapyProgram;



}
