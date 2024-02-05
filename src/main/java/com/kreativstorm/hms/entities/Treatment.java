package com.kreativstorm.hms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Treatment {
  @Id
  Long id;
  @Column(name = "medical_reportID")
  Integer medicalReportID;
  @Column(name = "departmentID")
  Integer departmentID;
  @Column(name = "description")
  String treatmentDescription;
}
