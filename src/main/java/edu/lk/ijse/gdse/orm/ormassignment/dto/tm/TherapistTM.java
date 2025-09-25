package edu.lk.ijse.gdse.orm.ormassignment.dto.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TherapistTM {


    private int id;

    private String name;

    private String email;

    private int therapyProgramId;


}
