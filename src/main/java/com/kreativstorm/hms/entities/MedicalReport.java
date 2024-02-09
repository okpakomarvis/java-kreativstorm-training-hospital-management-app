package com.kreativstorm.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "HMS.MEDICAL_REPORT")
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull(message = "must not be null")
    @Pattern(
            regexp = "^[\\w\\-\\s]+$",
            message = "only letters, numbers and hyphen allowed"
    )
    String name;
    @NotNull(message = "must not be null")
    @JoinTable(name = "HMS.USERS", joinColumns = @JoinColumn(name = "id"))
    Integer patientID;
    @NotNull(message = "must not be null")
    @JoinTable(name = "HMS.USERS", joinColumns = @JoinColumn(name = "id"))
    Integer doctorID;
    @NotNull(message = "must not be null")
    @JoinTable(name = "HMS.TREATMENT", joinColumns = @JoinColumn(name = "id"))
    Integer treatmentID;
    Date date;

    @NotNull(message = "must not be null")
    String diagnosis;
    @NotNull(message = "must not be null")
    String prescription;
}
