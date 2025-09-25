package edu.lk.ijse.gdse.orm.ormassignment.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class TherapySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int therapySessionId;

    private LocalDateTime sheduledTime;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;



    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Therapist therapist;




}
