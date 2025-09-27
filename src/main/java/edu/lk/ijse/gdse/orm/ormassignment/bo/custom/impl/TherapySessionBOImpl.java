package edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapySessionBO;
import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.*;
import edu.lk.ijse.gdse.orm.ormassignment.dto.RegisterDetailsDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapySessionDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TherapySessionBOImpl implements TherapySessionBO {


    TherapySessionDAO therapySessionDAO = (TherapySessionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.THERAPY_SESSION);
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PATIENT);
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.THERAPIST);

//    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);

    TherapyProgramDAO therapyProgramDAO1 = (TherapyProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);

    RegisterDetailsDAO registerDetailsDAO = (RegisterDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.REGISTER_DETAILS);




    @Override
    public boolean saveTherapySession(TherapySessionDTO therapySessionDTO, RegisterDetailsDTO registerDetailsDTO) {


        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();



        TherapySession therapySession = new TherapySession();
        therapySession.setTherapySessionId(therapySessionDTO.getTherapySessionId());
        therapySession.setSheduledTime(therapySessionDTO.getSheduledTime());



        Patient patient = patientDAO.getPatientById(therapySessionDTO.getPatientId());
        therapySession.setPatient(patient);




        Therapist therapist = therapistDAO.getTherapistById(therapySessionDTO.getTherapistId());
        therapySession.setTherapist(therapist);


        TherapyProgram therapyProgram = therapyProgramDAO1.findById(registerDetailsDTO.getTherapyProgramId());



        try {


            boolean flag1 = therapySessionDAO.saveTherapySession(therapySession, session);

            if (flag1) {

                RegisterDetails registerDetails = new RegisterDetails();

                registerDetails.setRegisterDetailsId(registerDetailsDTO.getRegisterDetailsId());
                registerDetails.setDate(registerDetailsDTO.getDate());
                registerDetails.setNumberOfSessions(registerDetailsDTO.getNumberOfSessions() - 1);
                registerDetails.setPatient(patient);


                registerDetails.setTherapyProgram(therapyProgram);

                boolean flag2 = registerDetailsDAO.updateRegisterDetails(registerDetails, session);

                if (flag2) {

                    transaction.commit();
                    session.close();
                    return true;

                } else {
                    transaction.rollback();
                    session.close();
                    return false;
                }


            } else {

                transaction.rollback();
                session.close();
                return false;

            }




        } catch (Exception e) {
            throw new RuntimeException(e);

        }



    }

    @Override
    public List<TherapySessionDTO> getTherapySessions() {

        List<TherapySession> therapySessions;
        List<TherapySessionDTO> therapySessionDTOs = new ArrayList<TherapySessionDTO>();

        try {
            therapySessions = therapySessionDAO.getAll();

            for (TherapySession therapySession : therapySessions) {
                TherapySessionDTO therapySessionDTO = new TherapySessionDTO();
                therapySessionDTO.setTherapySessionId(therapySession.getTherapySessionId());
                therapySessionDTO.setSheduledTime(therapySession.getSheduledTime());
                therapySessionDTO.setPatientId(therapySession.getPatient().getPatientId());
                therapySessionDTO.setTherapistId(therapySession.getTherapist().getId());
                therapySessionDTOs.add(therapySessionDTO);

            }

            return therapySessionDTOs;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
