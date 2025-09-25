package edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.RegisterDetailsDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.RegisterDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegisterDetailsDAOImpl implements RegisterDetailsDAO {


    @Override
    public boolean save(RegisterDetails entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();


        return true;
    }


    
    @Override
    public List<RegisterDetails> getAll() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction tx = session.beginTransaction();
        List<RegisterDetails> registerDetailsList = session.createQuery("from RegisterDetails").list();
        tx.commit();
        session.close();


        return registerDetailsList;
    }




    @Override
    public boolean update(RegisterDetails entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }
}
