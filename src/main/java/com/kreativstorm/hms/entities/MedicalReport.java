package com.kreativstorm.hms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalReport {
    String name;
    Integer patientID;
    Integer doctorID;
    Integer treatmentID;
    Date date;
    String diagnosis;
    String prescription;
}
