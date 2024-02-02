package com.kreativstorm.hms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicalReport {
    @Id
    Long id;
    String name;
    Integer patientID;
    Integer doctorID;
    Integer treatmentID;
    Date date;
    String diagnosis;
    String prescription;
}
