package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.entities.Department;
import com.kreativstorm.hms.repositories.DepartmentRepository;
import com.kreativstorm.hms.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartmentsByName(String name){
        return  departmentRepository.getDepartmentsByNameContainingIgnoreCase(name);
    }
}
