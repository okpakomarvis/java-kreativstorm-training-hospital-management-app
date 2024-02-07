package com.kreativstorm.hms.entities;

import jakarta.persistence.*;
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
    String name;
    @JoinTable(name = "HMS.USERS", joinColumns = @JoinColumn(name = "id"))
    Integer patientID;
    @JoinTable(name = "HMS.USERS", joinColumns = @JoinColumn(name = "id"))
    Integer doctorID;
    @JoinTable(name = "HMS.TREATMENT", joinColumns = @JoinColumn(name = "id"))
    Integer treatmentID;
    Date date;
    String diagnosis;
    String prescription;
}
