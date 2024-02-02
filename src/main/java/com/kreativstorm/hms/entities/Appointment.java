package com.kreativstorm.hms.entities;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    private Long id;
    Integer patientID;
    Integer doctorID;
    @Column(name = "schedule_for")
    LocalDateTime scheduledFor;
}
