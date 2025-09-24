package edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.TherapyProgramDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TherapyProgramDAOImpl implements TherapyProgramDAO {
    @Override
    public boolean save(TherapyProgram entity) throws Exception {


        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();


        return true;
    }

    @Override
    public List<TherapyProgram> getAll() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();
        List<TherapyProgram> list = session.createNativeQuery("SELECT * FROM therapy_program", TherapyProgram.class).list();
        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public boolean update(TherapyProgram entity) throws Exception {
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

        session.createNativeQuery("delete from therapy_program where therapy_program_id='"+id+"'",TherapyProgram.class).executeUpdate();

        transaction.commit();
        session.close();


        return true;
    }




}
