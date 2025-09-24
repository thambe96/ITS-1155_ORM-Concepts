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
@Table(name = "therapy_program")

public class TherapyProgram {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "therapy_program_id")
    private int therapyProgramId;

    @Column(name = "therapy_program_name")
    private String therapyProgramName;

    private int duration;
    private double fee;


    @OneToMany(mappedBy = "therapyProgram", cascade = CascadeType.ALL)
    private List<RegisterDetails> registerDetails;

    @OneToMany(mappedBy = "therapyProgram", cascade = CascadeType.ALL)
    private List<Therapist> therapists;


}
