package com.kreativstorm.hms.entities;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HMS.APPOINTMENT")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "must not be null")
    @JoinTable(name = "HMS.USERS", joinColumns = @JoinColumn(name = "id"))
    Integer patientID;
    @NotNull(message = "must not be null")
    @JoinTable(name = "HMS.USERS", joinColumns = @JoinColumn(name = "id"))
    Integer doctorID;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "schedule_for")
    LocalDateTime scheduledFor;
}
