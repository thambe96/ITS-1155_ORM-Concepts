package edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.TherapyProgramBO;
import edu.lk.ijse.gdse.orm.ormassignment.config.FactoryConfiguration;
import edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.TherapyProgramDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.TherapyProgramDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;
import edu.lk.ijse.gdse.orm.ormassignment.entity.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory.DAOType.THERAPY_PROGRAM;

public class TherapyProgramBOImpl implements TherapyProgramBO {




    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getDaoFactory().getDAO(THERAPY_PROGRAM);

    ModelMapper modelMapper = new ModelMapper();



    @Override
    public boolean saveTherapyProgram(TherapyProgramDTO therapyProgramDTO) {

        try {
            return therapyProgramDAO.save(modelMapper.map(therapyProgramDTO, TherapyProgram.class));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }




    @Override
    public List<TherapyProgramDTO> getAllTherapyPrograms() {



/*

        List<TherapyProgramDTO> allTherapyPrograms = new ArrayList<>();

        try {

            List<TherapyProgram> all = therapyProgramDAO.getAll();

            for (TherapyProgram therapyProgram : all) {

                allTherapyPrograms.add(new TherapyProgramDTO(

                        therapyProgram.getTherapyProgramId(),
                        therapyProgram.getTherapyProgramName(),
                        therapyProgram.getDuration(),
                        therapyProgram.getFee()

                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
*/




        return null /*allTherapyPrograms*/;

    }

    @Override
    public boolean updateTherapyProgram(TherapyProgramDTO therapyProgramDTO) {



     /*
        try {
            return therapyProgramDAO.update(new TherapyProgram(

                    therapyProgramDTO.getTherapyProgramId(),
                    therapyProgramDTO.getTherapyProgramName(),
                    therapyProgramDTO.getDuration(),
                    therapyProgramDTO.getFee()

            ));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        return false;

    }

    @Override
    public boolean deleteTherapyProgram(String therapyProgramID) {
        try {
            return therapyProgramDAO.delete(therapyProgramID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
