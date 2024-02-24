package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.entities.Treatment;
import com.kreativstorm.hms.exception.ClientException;
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
    @PutMapping("/update/{id}")
    public ResponseEntity<Treatment> upadateTreatment(@PathVariable("id") Integer id,
                                                              @Valid @RequestBody Treatment treatment){
        Optional<Treatment> treatment1 = treatmentService.update(id, treatment);
        if(treatment1.isEmpty()){
            throw new ClientException("Treatment Not Found");
        }
        return new ResponseEntity<>(treatment1.get(), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        treatmentService.deleteTreatment(id);
    }
}
