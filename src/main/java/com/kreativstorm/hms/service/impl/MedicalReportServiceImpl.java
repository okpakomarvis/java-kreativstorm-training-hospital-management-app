package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.exception.ClientException;
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

    @Override
    public void deleteMedRep(Integer medRepID) {
        Optional<MedicalReport> medicalReport  = medicalReportRepository.findById(medRepID);
        if(medicalReport.isEmpty()){
            throw new ClientException("Medical report does not exist");
        }else {
            medicalReportRepository.deleteById(medRepID);
        }
    }

    @Override
    public Optional<MedicalReport> update(int id, MedicalReport medicalReport) {
        MedicalReport medicalReport1 = new MedicalReport();
        medicalReport1.setId((long) id);
        medicalReport1.setDoctorID(medicalReport.getDoctorID());
        medicalReport1.setPatientID(medicalReport.getPatientID());
        medicalReport1.setDate(medicalReport.getDate());
        medicalReport1.setName(medicalReport.getName());
        medicalReport1.setDiagnosis(medicalReport.getDiagnosis());
        medicalReport1.setPrescription(medicalReport.getPrescription());
        if(medicalReport.getTreatmentID() != null)
            medicalReport1.setTreatmentID(medicalReport.getTreatmentID());
        return Optional.of(medicalReportRepository.saveAndFlush(medicalReport1));
    }
}
