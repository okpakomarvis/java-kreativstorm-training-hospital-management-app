package com.kreativstorm.hms.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HMS.TREATMENT")
public class Treatment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @NotNull(message = "must not be null")
  @Column(name = "medical_reportID")
  @JoinTable(name = "HMS.MEDICAL_REPORT", joinColumns = @JoinColumn(name = "id"))
  Integer medicalReportID;
  @NotNull(message = "must not be null")
  @Column(name = "departmentID")
  @JoinTable(name = "HMS.DEPARTMENT", joinColumns = @JoinColumn(name = "id"))
  Integer departmentID;
  @NotNull(message = "must not be null")
  @Column(name = "description")
  String treatmentDescription;
}
