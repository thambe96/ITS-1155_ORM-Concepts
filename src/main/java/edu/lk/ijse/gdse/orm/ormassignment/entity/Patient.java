package edu.lk.ijse.gdse.orm.ormassignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "patient")
public class Patient {


    @Id
    @Column(name = "patient_id")
    private String patientId;


    private String patientName;

    private String patientGender;
    private int patientAge;
    private String patientAddress;
    private String patientEmail;



}
