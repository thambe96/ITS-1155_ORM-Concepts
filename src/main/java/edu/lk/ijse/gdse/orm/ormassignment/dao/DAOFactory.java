package edu.lk.ijse.gdse.orm.ormassignment.dao;

import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl.PatientDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {
        return daoFactory == null ?
                daoFactory = new DAOFactory() :
                daoFactory;
    }

    public enum DAOType {
        PATIENT;
    }

    public SuperDAO getDAO(DAOType type) {

        return switch (type) {
            case PATIENT -> new PatientDAOImpl();
            default -> null;
        };

    }




}
