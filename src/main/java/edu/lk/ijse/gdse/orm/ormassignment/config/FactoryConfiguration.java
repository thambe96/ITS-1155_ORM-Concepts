package edu.lk.ijse.gdse.orm.ormassignment.config;

import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {

        Configuration config = new Configuration(); //.configure();

        config.addAnnotatedClass(Patient.class);
//        config.addAnnotatedClass(Orders.class);



/*
        Properties hibernateProperties = new Properties();
        try {
            hibernateProperties.load(ClassLoader.getSystemResourceAsStream("/hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        config.mergeProperties(hibernateProperties);


        */




        sessionFactory = config.buildSessionFactory();

    }


    public static FactoryConfiguration getInstance() {
        if (factoryConfiguration == null) {
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSessionFactory() {
        return sessionFactory.openSession();
    }




}
