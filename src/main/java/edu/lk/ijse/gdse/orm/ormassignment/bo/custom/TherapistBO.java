package edu.lk.ijse.gdse.orm.ormassignment.bo.custom;

import edu.lk.ijse.gdse.orm.ormassignment.bo.SuperBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapistDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Therapist;

public interface TherapistBO extends SuperBO {


    public boolean saveTherapist(TherapistDTO therapistDTO);




}
