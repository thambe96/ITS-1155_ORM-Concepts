package edu.lk.ijse.gdse.orm.ormassignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "patient")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<RegisterDetails> registerDetails;



}
