package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/{id}")
    ResponseEntity<Appointment> getAppointmentByPatientID(@PathVariable("id") Integer patientID){
        return appointmentService.getAppointment(patientID).map(Appointment -> ResponseEntity.status(HttpStatus.FOUND)
                .body(Appointment)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
