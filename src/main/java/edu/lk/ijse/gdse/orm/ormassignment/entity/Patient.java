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

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_gender")
    private String patientGender;

    @Column(name = "patient_age")
    private int patientAge;

    @Column(name = "patient_address")
    private String patientAddress;

    @Column(name = "patient_email")
    private String patientEmail;



}
