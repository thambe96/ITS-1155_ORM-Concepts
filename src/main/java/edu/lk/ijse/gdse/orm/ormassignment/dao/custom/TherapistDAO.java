package edu.lk.ijse.gdse.orm.ormassignment.dao.custom;

import edu.lk.ijse.gdse.orm.ormassignment.dao.CrudDAO;
import edu.lk.ijse.gdse.orm.ormassignment.entity.Therapist;

import java.time.LocalDateTime;
import java.util.List;

public interface TherapistDAO extends CrudDAO<Therapist> {


    public List<Therapist> getAllAvailableTherapists(int programId, LocalDateTime timeSlot);
    public Therapist getTherapistById(int therapistId);
    public boolean delete(int therapistId);


}
