package edu.lk.ijse.gdse.orm.ormassignment.dao.custom;

import edu.lk.ijse.gdse.orm.ormassignment.dao.CrudDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.RegisterDetails;
import org.hibernate.Session;

public interface RegisterDetailsDAO extends CrudDAO<RegisterDetails> {

    public boolean updateRegisterDetails(RegisterDetails registerDetails, Session session);


}
