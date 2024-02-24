package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.entities.Treatment;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.repositories.TreatmentRepository;
import com.kreativstorm.hms.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;

    @Override
    public Optional<Treatment> getTreatment(Integer id) {
        return treatmentRepository.findTreatmentById(id);
    }

    @Override
    public void saveTreatment(Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    @Override
    public void deleteTreatment(Integer treatmentID) {
        Optional<Treatment> treatment  = treatmentRepository.findById(treatmentID);
        if(treatment.isEmpty()){
            throw new ClientException("Treatment does not exist");
        }else {
            treatmentRepository.deleteById(treatmentID);
        }
    }

    @Override
    public Optional<Treatment> update(int id, Treatment treatment) {
        Treatment treatment1 = new Treatment();
        treatment1.setId((long) id);
        treatment1.setDepartmentID(treatment.getDepartmentID());
        treatment1.setMedicalReportID(treatment.getMedicalReportID());
        treatment1.setTreatmentDescription(treatment.getTreatmentDescription());

        return Optional.of(treatmentRepository.saveAndFlush(treatment1));
    }
}
