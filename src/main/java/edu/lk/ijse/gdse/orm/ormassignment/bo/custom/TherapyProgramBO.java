package edu.lk.ijse.gdse.orm.ormassignment.bo.custom;

import edu.lk.ijse.gdse.orm.ormassignment.bo.SuperBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapyProgramDTO;

import java.util.List;

public interface TherapyProgramBO extends SuperBO {

    public boolean saveTherapyProgram(TherapyProgramDTO therapyProgramDTO);
    public List<TherapyProgramDTO> getAllTherapyPrograms();
    public boolean updateTherapyProgram(TherapyProgramDTO therapyProgramDTO);
    public boolean deleteTherapyProgram(String therapyProgramID);


}
