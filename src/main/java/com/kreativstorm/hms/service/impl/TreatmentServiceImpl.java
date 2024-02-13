package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.entities.Treatment;
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
}
