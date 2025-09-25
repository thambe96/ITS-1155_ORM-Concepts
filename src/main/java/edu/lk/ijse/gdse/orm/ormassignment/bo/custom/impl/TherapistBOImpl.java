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

import java.util.ArrayList;
import java.util.List;

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




    @Override
    public List<TherapistDTO> getTherapists() {

        try {
            List<Therapist> allTherapists = therapistDAO.getAll();

            List<TherapistDTO> therapistDTOs = new ArrayList<TherapistDTO>();

            for (Therapist therapist : allTherapists) {

                TherapistDTO therapistDTO = new TherapistDTO();

                therapistDTO.setId(therapist.getId());
                therapistDTO.setName(therapist.getName());
                therapistDTO.setEmail(therapist.getEmail());
                therapistDTO.setTherapyProgramId(therapist.getTherapyProgram().getTherapyProgramId());

                therapistDTOs.add(therapistDTO);


            }

            return therapistDTOs;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }




}
