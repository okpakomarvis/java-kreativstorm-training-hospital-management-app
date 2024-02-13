package com.kreativstorm.hms.service.impl;


import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.repositories.AppointmentRepository;
import com.kreativstorm.hms.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Optional<Appointment> getAppointment(Integer patientID) {
        return appointmentRepository.getAppointmentByPatientID(patientID);
    }
}
