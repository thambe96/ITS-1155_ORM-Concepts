package edu.lk.ijse.gdse.orm.ormassignment.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Data

public class RegisterDetailsTM {

    private int registerDetailsId;
    private Date date;
    private int numberOfSessions;
    private int patientId;
    private int therapyProgramId;



}
