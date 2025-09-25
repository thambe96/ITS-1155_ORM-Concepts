package edu.lk.ijse.gdse.orm.ormassignment.bo.custom;

import edu.lk.ijse.gdse.orm.ormassignment.bo.SuperBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapistDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Therapist;

import java.util.List;

public interface TherapistBO extends SuperBO {


    public boolean saveTherapist(TherapistDTO therapistDTO);
    public List<TherapistDTO> getTherapists();




}
