package edu.lk.ijse.gdse.orm.ormassignment.dto;

import edu.lk.ijse.gdse.orm.ormassignment.entity.RegisterDetails;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    private List<RegisterDetails> registerDetails;


}



