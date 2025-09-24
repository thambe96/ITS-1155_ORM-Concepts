package edu.lk.ijse.gdse.orm.ormassignment.dto;

import edu.lk.ijse.gdse.orm.ormassignment.entity.RegisterDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TherapyProgramDTO {

    private int therapyProgramId;
    private String therapyProgramName;
    private int duration;
    private double fee;

    private List<RegisterDetails> registerDetails;




}
