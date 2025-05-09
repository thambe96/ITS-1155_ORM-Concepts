package edu.lk.ijse.gdse.orm.ormassignment.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PatientDTO {

    private String patientId;


    private String patientName;

    private String patientGender;
    private int patientAge;
    private String patientAddress;
    private String patientEmail;


}
