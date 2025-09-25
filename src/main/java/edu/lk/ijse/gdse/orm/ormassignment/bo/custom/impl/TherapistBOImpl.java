package edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapistBO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.TherapistDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.TherapyProgramDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.impl.TherapistDAOImpl;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapistDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Therapist;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapyProgram;
import org.modelmapper.ModelMapper;

public class TherapistBOImpl implements TherapistBO {

    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.THERAPIST);
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public boolean saveTherapist(TherapistDTO therapistDTO) {

        try {



            TherapyProgram therapyProgram = therapyProgramDAO.findById(therapistDTO.getId());

            Therapist therapist = new Therapist();
            therapist.setName(therapistDTO.getName());
            therapist.setEmail(therapistDTO.getEmail());
            therapist.setTherapyProgram(therapyProgram);

            therapistDAO.save(therapist);
            return true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }





}
