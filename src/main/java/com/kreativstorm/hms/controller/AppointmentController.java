package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.entities.AppointmentDTO;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.service.AppointmentService;
import com.kreativstorm.hms.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentByPatientID(@PathVariable("id") Integer patientID){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        if(appointmentService.getAppointment(patientID).isPresent()){
            Appointment app = appointmentService.getAppointment(patientID).get();
            appointmentDTO.setScheduledFor(app.getScheduledFor());
            appointmentDTO.setPatient(usersService.getUserByID(patientID.longValue()).get());
            appointmentDTO.setDoctor(usersService.getUserByID(app.getDoctorID().longValue()).get());
            return ResponseEntity.status(HttpStatus.FOUND).body(appointmentDTO);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/all-appointments")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        List<Appointment> appointments = appointmentService.getAll();
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        for(Appointment app: appointments){
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setScheduledFor(app.getScheduledFor());
            appointmentDTO.setPatient(usersService.getUserByID(app.getPatientID().longValue()).get());
            appointmentDTO.setDoctor(usersService.getUserByID(app.getDoctorID().longValue()).get());
            appointmentDTOS.add(appointmentDTO);
        }

        if (!appointmentDTOS.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(appointmentDTOS);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

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
