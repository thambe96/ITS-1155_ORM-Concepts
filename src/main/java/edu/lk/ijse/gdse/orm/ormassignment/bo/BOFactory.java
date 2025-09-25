package edu.lk.ijse.gdse.orm.ormassignment.bo;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBoFactory() {
        return boFactory == null ?
                boFactory = new BOFactory() :
                boFactory;
    }

    public enum BOType {
        PATIENT_BO, THERAPY_PROGRAM_BO, REGISTER_DETAILS_BO, THERAPIST, THERAPY_SESSION_BO;
    }

    public SuperBO getBO(BOType type) {
        return switch (type) {
            case PATIENT_BO -> new PatientBOImpl();
            case THERAPY_PROGRAM_BO -> new TherapyProgramBOImpl();
            case REGISTER_DETAILS_BO -> new RegisterDetailsBOImpl();
            case THERAPIST -> new TherapistBOImpl();
            case THERAPY_SESSION_BO -> new TherapySessionBOImpl();
            default -> null;
        };
    }




}
