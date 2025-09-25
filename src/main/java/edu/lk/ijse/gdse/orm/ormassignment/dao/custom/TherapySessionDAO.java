package edu.lk.ijse.gdse.orm.ormassignment.dao.custom;

import edu.lk.ijse.gdse.orm.ormassignment.dao.CrudDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapySession;
import org.hibernate.Session;

public interface TherapySessionDAO extends CrudDAO<TherapySession> {

    public boolean saveTherapySession(TherapySession therapySession, Session session);

}
