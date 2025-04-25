package edu.lk.ijse.gdse.orm.ormassignment.dto.tm;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PatientTM {

    private String patientId;


    private String patientName;
    private String patientGender;
    private int patientAge;
    private String patientAddress;
    private String patientEmail;

}
