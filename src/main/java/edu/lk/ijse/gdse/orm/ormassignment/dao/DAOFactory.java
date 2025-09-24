package edu.lk.ijse.gdse.orm.ormassignment.dao;

import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl.PatientDAOImpl;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl.RegisterDetailsDAOImpl;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl.TherapyProgramDAOImpl;

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
        PATIENT, THERAPY_PROGRAM, REGISTER_DETAILS;
    }

    public SuperDAO getDAO(DAOType type) {

        return switch (type) {
            case PATIENT -> new PatientDAOImpl();
            case THERAPY_PROGRAM -> new TherapyProgramDAOImpl();
            case REGISTER_DETAILS -> new RegisterDetailsDAOImpl();
            default -> null;
        };

    }




}
