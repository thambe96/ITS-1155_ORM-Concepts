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
@Table(name = "therapy_program")

public class TherapyProgram {


    @Id
    @Column(name = "therapy_program_id")
    private String therapyProgramId;

    @Column(name = "therapy_program_name")
    private String therapyProgramName;

    private int duration;
    private double fee;





}
