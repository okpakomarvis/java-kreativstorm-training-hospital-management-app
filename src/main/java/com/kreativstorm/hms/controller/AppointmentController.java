package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
