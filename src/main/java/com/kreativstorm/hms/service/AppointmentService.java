package com.kreativstorm.hms.service;

import com.kreativstorm.hms.controller.AppointmentController;
import com.kreativstorm.hms.dto.SignUpRequest;
import com.kreativstorm.hms.entities.Appointment;
import com.kreativstorm.hms.entities.Users;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> getAppointments(Integer patientID);

    void saveAppointment(Appointment appointment);
    void deleteAppointment(Integer appointmentId);

    Optional<Appointment> update(int id, Appointment appointment);

    List<Appointment> getAll();
}
