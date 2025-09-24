package edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.PatientDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public boolean save(Patient entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();


        return true;
    }

    @Override
    public List<Patient> getAll() throws Exception {


        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();
        List<Patient> list = session.createNativeQuery("SELECT * FROM patient", Patient.class).list();
        transaction.commit();
        session.close();
        return list;

    }

    @Override
    public boolean update(Patient entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();

        Transaction transaction = session.beginTransaction();

        session.createNativeQuery("delete from patient where patient_id='"+id+"'",Patient.class).executeUpdate();

        transaction.commit();
        session.close();


        return true;
    }





    /*
    @Override
    public String getNextId() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        String lastId = session.createNativeQuery("SELECT patient_id FROM patient ORDER BY patient_id DESC LIMIT 1", String.class)
                .getSingleResultOrNull();



         transaction.commit();
         session.close();

         if (lastId != null) {
             String substring = lastId.substring(1); // Extract the numeric part
             int i = Integer.parseInt(substring); // Convert the numeric part to integer
             int newIdIndex = i + 1; // Increment the number by 1
             return String.format("P%03d", newIdIndex);

         }

        return "P001";
    }

    */





}
