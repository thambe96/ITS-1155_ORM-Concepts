package edu.lk.ijse.gdse.orm.ormassignment.bo.custom;

import edu.lk.ijse.gdse.orm.ormassignment.bo.SuperBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.RegisterDetailsDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapySessionDTO;

public interface TherapySessionBO extends SuperBO {

    public boolean saveTherapySession(TherapySessionDTO therapySession, RegisterDetailsDTO registerDetailsDTO);


}
