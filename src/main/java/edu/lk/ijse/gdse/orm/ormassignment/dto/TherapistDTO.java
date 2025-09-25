package edu.lk.ijse.gdse.orm.ormassignment.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TherapistDTO {

    private int id;

    private String name;

    private String email;

    private int therapyProgramId;


}
