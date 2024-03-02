package com.kreativstorm.hms.service.impl;


import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.entities.Role;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.repositories.AppointmentRepository;
import com.kreativstorm.hms.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAppointments(Integer patientID) {
        return appointmentRepository.findAllByPatientID(patientID);
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Integer appointmentID) {
        Optional<Appointment> appointment  = appointmentRepository.findById(appointmentID);
        if(appointment.isEmpty()){
            throw new ClientException("User does not exist");
        }else {
            appointmentRepository.deleteById(appointmentID);
        }
    }

    @Override
    public Optional<Appointment> update(int id, Appointment appointment) {
        Appointment appointment1 = new Appointment();
        appointment1.setId((long) id);
        appointment1.setDoctorID(appointment.getDoctorID());
        appointment1.setPatientID(appointment.getPatientID());
        appointment1.setScheduledFor(appointment.getScheduledFor());
        return Optional.of(appointmentRepository.saveAndFlush(appointment1));
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
}
