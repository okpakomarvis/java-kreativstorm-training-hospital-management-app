package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.service.MedicalReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/medical")
public class MedicalReportController {
    @Autowired
    MedicalReportService medicalReportService;

    @GetMapping("/{id}")
    ResponseEntity<MedicalReport> getMedRepByPatient(@PathVariable("id") Integer patientID){
        return medicalReportService.getMedRep(patientID).map(MedicalReport -> ResponseEntity.status(HttpStatus.FOUND)
                .body(MedicalReport)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public void addMedRep(@RequestBody @Valid MedicalReport medicalReport){
        medicalReportService.saveMedRep(medicalReport);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalReport> upadateMedicalReport(@PathVariable("id") Integer id,
                                                          @Valid @RequestBody MedicalReport medicalReport){
        Optional<MedicalReport> medicalReport1 = medicalReportService.update(id, medicalReport);
        if(medicalReport1.isEmpty()){
            throw new ClientException("Medical report Not Found");
        }
        return new ResponseEntity<>(medicalReport1.get(), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        medicalReportService.deleteMedRep(id);
    }
}
