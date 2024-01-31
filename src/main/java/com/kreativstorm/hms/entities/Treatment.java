package com.kreativstorm.hms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treatment {
  Integer patientID;
  Department department;
  String diagnosis;
  String treatmentDescription;
  String prescription;
}
