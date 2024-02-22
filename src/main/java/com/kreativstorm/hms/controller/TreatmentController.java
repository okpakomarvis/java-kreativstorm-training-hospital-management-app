package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Treatment;
import com.kreativstorm.hms.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
<<<<<<< HEAD
@RequestMapping("hms")
@CrossOrigin(origins = "http://localhost:4200")
=======
@RequestMapping("/api/v1/treatments")
>>>>>>> 894f12e529360fca67f1c58310f63373596da94d
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;

    @GetMapping("/treatment/{id}")
    ResponseEntity<Treatment> getTreatmentByPatientID(@PathVariable("id") Integer id){
        return treatmentService.getTreatment(id).map(Treatment -> ResponseEntity.status(HttpStatus.FOUND)
                .body(Treatment)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
