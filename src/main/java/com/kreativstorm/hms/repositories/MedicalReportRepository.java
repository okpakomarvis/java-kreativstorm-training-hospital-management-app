package com.kreativstorm.hms.repositories;

import com.kreativstorm.hms.entities.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReport, Integer> {
    Optional<MedicalReport> findMedicalReportByPatientID(Integer patientID);
}
