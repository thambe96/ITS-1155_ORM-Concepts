package edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.UserDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDAOImpl implements UserDAO {


    @Override
    public boolean save(User entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();

        return true;
    }



    @Override
    public List<User> getAll() throws Exception {
        return List.of();
    }



    @Override
    public boolean update(User entity) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.beginTransaction();






        session.merge(entity);





        session.getTransaction().commit();
        session.close();



        return true;
    }





    @Override
    public boolean delete(String id) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

        return true;
    }




    public User findByUsername(String username) {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.beginTransaction();

//        User user = (User) session.get(User.class, username);

        User user = session.createNativeQuery(
                        "SELECT * FROM user WHERE username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();


        session.getTransaction().commit();
        session.close();

        return user;
    }

    @Override
    public User findByUsernameByUserNameAndPassword(String username, String password) {

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        session.beginTransaction();

//        User user = (User) session.get(User.class, username);

        User user = session.createNativeQuery(
                        "SELECT * FROM user WHERE username = :username AND password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();


        session.getTransaction().commit();
        session.close();

        return user;
    }









}
