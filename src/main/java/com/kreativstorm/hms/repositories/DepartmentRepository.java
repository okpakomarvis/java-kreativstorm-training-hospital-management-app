package com.kreativstorm.hms.repositories;

import com.kreativstorm.hms.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> getDepartmentsByNameContainingIgnoreCase(String name);
}
