package edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.RegisterDetailsBO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.PatientDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.RegisterDetailsDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.TherapyProgramDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.RegisterDetailsDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;
import edu.lk.ijse.gdse.orm.ormassignment.entity.RegisterDetails;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapyProgram;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class RegisterDetailsBOImpl implements RegisterDetailsBO {


    RegisterDetailsDAO registerDetailsDAO = (RegisterDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.REGISTER_DETAILS);
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PATIENT);
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public boolean saveRegisterDetails(RegisterDetailsDTO registerDetailsDTO) throws Exception {



       Patient patient = patientDAO.getPatientById(registerDetailsDTO.getPatientId());
       TherapyProgram therapyProgram = therapyProgramDAO.findById(registerDetailsDTO.getTherapyProgramId());

       RegisterDetails registerDetails = new RegisterDetails();
       registerDetails.setPatient(patient);
       registerDetails.setTherapyProgram(therapyProgram);
       registerDetails.setDate(registerDetailsDTO.getDate());
       registerDetails.setNumberOfSessions(registerDetailsDTO.getNumberOfSessions());


        boolean result = registerDetailsDAO.save(registerDetails);

        return result;
    }

    @Override
    public List<RegisterDetailsDTO> getRegisterDetails() throws Exception {

        List<RegisterDetails> allRegisterDetailsList = registerDetailsDAO.getAll();

        List<RegisterDetailsDTO> registerDetailsDTOList = new ArrayList<RegisterDetailsDTO>();

        for (RegisterDetails registerDetails : allRegisterDetailsList) {

            RegisterDetailsDTO registerDetailsDTO = new RegisterDetailsDTO();

            registerDetailsDTO.setRegisterDetailsId(registerDetails.getRegisterDetailsId());
            registerDetailsDTO.setPatientId(registerDetails.getPatient().getPatientId());
            registerDetailsDTO.setDate(registerDetails.getDate());
            registerDetailsDTO.setNumberOfSessions(registerDetails.getNumberOfSessions());
            registerDetailsDTO.setTherapyProgramId(registerDetails.getTherapyProgram().getTherapyProgramId());



            registerDetailsDTOList.add(registerDetailsDTO);

        }


        return registerDetailsDTOList;
    }

}
