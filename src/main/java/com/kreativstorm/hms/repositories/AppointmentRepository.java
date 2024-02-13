package com.kreativstorm.hms.repositories;

import com.kreativstorm.hms.entities.Appointment;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Optional<Appointment> getAppointmentByPatientID(Integer patientID);
}
