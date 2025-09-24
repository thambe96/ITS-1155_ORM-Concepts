package edu.lk.ijse.gdse.orm.ormassignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "register_details")

public class RegisterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_det_id")
    private int registerDetailsId;


    private Date date;


    @Column(name = "num_of_sessions")
    private int numberOfSessions;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "therapy_program_id")
    private TherapyProgram therapyProgram;






}
