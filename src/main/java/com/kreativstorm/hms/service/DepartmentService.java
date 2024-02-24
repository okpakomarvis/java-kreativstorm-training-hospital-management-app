package com.kreativstorm.hms.service;

import com.kreativstorm.hms.entities.Department;
import com.kreativstorm.hms.entities.MedicalReport;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAll();
    List<Department> getDepartmentsByName(String name);
    void saveDepartment(Department department);

    void deleteDepartment(Integer departmentID);

    Optional<Department> update(int id, Department department);

    Optional<Department> addPatient(Integer patientID, Department department);

    Optional<Department> addStaff(Integer staffID, Department department);

    Optional<Department> removePatient(Integer patientID, Department department);

    Optional<Department> removeStaff(Integer staffID, Department department);

}
