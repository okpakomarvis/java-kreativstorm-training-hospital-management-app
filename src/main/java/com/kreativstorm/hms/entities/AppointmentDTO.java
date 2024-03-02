package com.kreativstorm.hms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    public LocalDateTime scheduledFor;
    public Users patient;
    public Users doctor;
}
