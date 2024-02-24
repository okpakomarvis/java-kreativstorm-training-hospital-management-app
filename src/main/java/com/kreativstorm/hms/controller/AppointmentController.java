package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentByPatientID(@PathVariable("id") Integer patientID){
        return appointmentService.getAppointment(patientID).map(Appointment -> ResponseEntity.status(HttpStatus.FOUND)
                .body(Appointment)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/save")
    public void addAppointment(@RequestBody @Valid Appointment appointment){
         appointmentService.saveAppointment(appointment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> upadateAppointment(@PathVariable("id") Integer id,
                                             @Valid @RequestBody Appointment appointment){
        Optional<Appointment> appointment1 = appointmentService.update(id, appointment);
        if(appointment1.isEmpty()){
            throw new ClientException("Appointment Not Found");
        }
        return new ResponseEntity<>(appointment1.get(), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        appointmentService.deleteAppointment(id);
    }
}
