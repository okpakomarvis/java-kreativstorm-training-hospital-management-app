package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.repositories.MedicalReportRepository;
import com.kreativstorm.hms.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicalReportServiceImpl implements MedicalReportService {
    @Autowired
    MedicalReportRepository medicalReportRepository;
    @Override
    public Optional<MedicalReport> getMedRep(Integer patientID) {
        return medicalReportRepository.findMedicalReportByPatientID(patientID);
    }

    @Override
    public void saveMedRep(MedicalReport medicalReport) {
        medicalReportRepository.save(medicalReport);
    }
}
