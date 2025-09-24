package edu.lk.ijse.gdse.orm.ormassignment.bo.custom;

import edu.lk.ijse.gdse.orm.ormassignment.bo.SuperBO;
import edu.lk.ijse.gdse.orm.ormassignment.dto.PatientDTO;

import java.util.List;


public interface PatientBO extends SuperBO {

    public boolean savePatient(PatientDTO patientDTO);
    public List<PatientDTO> getAllPatients();
    public boolean updatePatient(PatientDTO patientDTO);
    public boolean deletePatient(String patientId);
    public PatientDTO getPatient(int patientId);

//    public String getNextPatientId();


}
