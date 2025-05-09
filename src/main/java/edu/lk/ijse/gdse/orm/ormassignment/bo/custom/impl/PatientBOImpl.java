package edu.lk.ijse.gdse.orm.ormassignment.bo.custom.impl;

import edu.lk.ijse.gdse.orm.ormassignment.bo.custom.PatientBO;
import edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory;
import edu.lk.ijse.gdse.orm.ormassignment.dao.custom.PatientDAO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Patient;

import java.util.ArrayList;
import java.util.List;

import static edu.lk.ijse.gdse.orm.ormassignment.dao.DAOFactory.DAOType.PATIENT;

public class PatientBOImpl implements PatientBO {


    PatientDAO patientDAO = (PatientDAO) DAOFactory.getDaoFactory().getDAO(PATIENT);


    @Override
    public boolean savePatient(PatientDTO patientDTO) {

        try {
            return patientDAO.save(new Patient(

                    patientDTO.getPatientId(),
                    patientDTO.getPatientName(),
                    patientDTO.getPatientGender(),
                    patientDTO.getPatientAge(),
                    patientDTO.getPatientAddress(),
                    patientDTO.getPatientEmail())


            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PatientDTO> getAllPatients() {

        List<PatientDTO> allPatients = new ArrayList<>();
        try {
            List<Patient> all = patientDAO.getAll();
            for (Patient patient : all) {
                allPatients.add(new PatientDTO(

                        patient.getPatientId(),
                        patient.getPatientName(),
                        patient.getPatientGender(),
                        patient.getPatientAge(),
                        patient.getPatientAddress(),
                        patient.getPatientEmail())
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return allPatients;
    }

    @Override
    public boolean updatePatient(PatientDTO patientDTO) {
        try {
            return patientDAO.update((new Patient(

                    patientDTO.getPatientId(),
                    patientDTO.getPatientName(),
                    patientDTO.getPatientGender(),
                    patientDTO.getPatientAge(),
                    patientDTO.getPatientAddress(),
                    patientDTO.getPatientEmail()))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deletePatient(String patientId) {

        try {
            return patientDAO.delete(patientId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
