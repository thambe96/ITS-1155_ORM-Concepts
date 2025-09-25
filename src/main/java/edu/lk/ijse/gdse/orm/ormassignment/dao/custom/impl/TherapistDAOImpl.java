package edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.TherapistDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Therapist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TherapistDAOImpl implements TherapistDAO {
    @Override
    public boolean save(Therapist entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();


        return true;
    }




    @Override
    public List<Therapist> getAll() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction tx = session.beginTransaction();
        List<Therapist> therapistsLists = session.createQuery("from Therapist").list();
        tx.commit();
        session.close();


        return therapistsLists;
    }





    @Override
    public boolean update(Therapist entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }
}
