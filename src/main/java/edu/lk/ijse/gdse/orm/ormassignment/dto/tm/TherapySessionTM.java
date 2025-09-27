package edu.lk.ijse.gdse.orm.ormassignment.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class TherapySessionTM {


    private int therapySessionId;

    private LocalDateTime sheduledTime;


    private int patientId;


    private int therapistId;




}
