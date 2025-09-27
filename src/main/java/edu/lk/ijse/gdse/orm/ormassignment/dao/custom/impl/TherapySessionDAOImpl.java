package edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.TherapySessionDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapySession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class TherapySessionDAOImpl implements TherapySessionDAO {
    @Override
    public boolean save(TherapySession entity) throws Exception {


/*

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
*/

        return true;
    }





    @Override
    public List<TherapySession> getAll() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.beginTransaction();


        List<TherapySession> list = session.createQuery("from TherapySession").list();
        session.getTransaction().commit();
        session.close();


        return list;
    }




    @Override
    public boolean update(TherapySession entity) throws Exception {
        return false;
    }




    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean saveTherapySession(TherapySession therapySession, Session session) {


        try {
            session.persist(therapySession);
            return true;

        } catch (Exception e) {
            return false;
        }

    }
}
