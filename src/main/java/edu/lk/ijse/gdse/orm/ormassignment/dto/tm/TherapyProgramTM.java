package edu.lk.ijse.gdse.orm.ormassignment.dto.tm;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TherapyProgramTM {

    private int therapyProgramId;
    private String therapyProgramName;
    private int duration;
    private double fee;


}
