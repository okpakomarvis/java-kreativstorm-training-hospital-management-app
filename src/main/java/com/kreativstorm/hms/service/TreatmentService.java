package com.kreativstorm.hms.service;

import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.entities.Treatment;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Optional;

public interface TreatmentService {
    Optional<Treatment> getTreatment(Integer patientID);
    void saveTreatment(Treatment treatment);
    void deleteTreatment(Integer treatmentID);

    Optional<Treatment> update(int id, Treatment treatment);
}
