package com.kreativstorm.hms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    Long id;
    @Column(name = "DepartmentName")
    String name;
    /*List<Integer> staff;
    List<Integer> patients;*/
}