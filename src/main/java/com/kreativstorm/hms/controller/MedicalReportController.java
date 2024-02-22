package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.service.MedicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hms")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalReportController {
    @Autowired
    MedicalReportService medicalReportService;

    @GetMapping("/medical-report/{id}")
    ResponseEntity<MedicalReport> getMedRepByPatient(@PathVariable("id") Integer patientID){
        return medicalReportService.getMedRep(patientID).map(MedicalReport -> ResponseEntity.status(HttpStatus.FOUND)
                .body(MedicalReport)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
