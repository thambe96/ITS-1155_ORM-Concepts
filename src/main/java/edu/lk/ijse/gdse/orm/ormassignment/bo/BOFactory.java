package edu.lk.ijse.gdse.orm.ormassignment.bo;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl.PatientBOImpl;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl.RegisterDetailsBOImpl;
import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl.TherapyProgramBOImpl;

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
        PATIENT_BO, THERAPY_PROGRAM_BO, REGISTER_DETAILS_BO;
    }

    public SuperBO getBO(BOType type) {
        return switch (type) {
            case PATIENT_BO -> new PatientBOImpl();
            case THERAPY_PROGRAM_BO -> new TherapyProgramBOImpl();
            case REGISTER_DETAILS_BO -> new RegisterDetailsBOImpl();
            default -> null;
        };
    }




}
