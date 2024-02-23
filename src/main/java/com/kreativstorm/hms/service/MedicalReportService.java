package com.kreativstorm.hms.service;

import com.kreativstorm.hms.entities.MedicalReport;

import java.util.Optional;

public interface MedicalReportService {
    Optional<MedicalReport> getMedRep(Integer patientID);
    void saveMedRep(MedicalReport medicalReport);
}
