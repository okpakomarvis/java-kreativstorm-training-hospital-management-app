package com.kreativstorm.hms.service;

import com.kreativstorm.hms.entities.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();
    List<Department> getDepartmentsByName(String name);
}
