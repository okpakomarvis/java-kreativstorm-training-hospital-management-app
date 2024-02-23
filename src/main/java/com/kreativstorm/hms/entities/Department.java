package com.kreativstorm.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "must not be null")
    @Size(min = 1, max = 50,
            message = "must be at least 1 character long and max 4 characters")
    @Pattern(
            regexp = "^[A-Za-z-]*$",
            message = "only letters and hyperfine allowed"
    )
    @Column(name = "DepartmentName")
    String name;

    @ManyToMany(targetEntity = Users.class, mappedBy = "staffDepartments")
    List<Users> staff;
    @ManyToMany(targetEntity = Users.class, mappedBy = "patiensDepartments")
    List<Users> patients;
}