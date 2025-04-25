package edu.lk.ijse.gdse.orm.ormassignment.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TherapyProgramDTO {

    private String therapyProgramId;
    private String therapyProgramName;
    private int duration;
    private double fee;




}
