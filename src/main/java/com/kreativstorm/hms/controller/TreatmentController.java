package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Treatment;
import com.kreativstorm.hms.service.TreatmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/treatments")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/{id}")
    ResponseEntity<Treatment> getTreatmentByPatientID(@PathVariable("id") Integer id){
        return treatmentService.getTreatment(id).map(Treatment -> ResponseEntity.status(HttpStatus.FOUND)
                .body(Treatment)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public void addTreatment(@RequestBody @Valid Treatment treatment){
        treatmentService.saveTreatment(treatment);
    }
}
