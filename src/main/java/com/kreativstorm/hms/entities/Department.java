package com.kreativstorm.hms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HMS.DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "DepartmentName")
    String name;

    @ManyToMany(targetEntity = Users.class, mappedBy = "departments")
    List<Users> staff;
    @ManyToMany(targetEntity = Users.class, mappedBy = "departments")
    List<Users> patients;
}