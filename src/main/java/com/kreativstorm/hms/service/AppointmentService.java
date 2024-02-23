package com.kreativstorm.hms.service;

import com.kreativstorm.hms.entities.Appointment;

import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> getAppointment(Integer patientID);

    void saveAppointment(Appointment appointment);
}
