package edu.lk.ijse.gdse.orm.ormassignment.bo.custom;

import edu.lk.ijse.gdse.orm.ormassignment.bo.SuperBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.RegisterDetailsDTO;

public interface RegisterDetailsBO extends SuperBO {

    public boolean saveRegisterDetails(RegisterDetailsDTO registerDetailsDTO) throws Exception;


}
