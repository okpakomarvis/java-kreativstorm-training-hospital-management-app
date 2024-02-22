package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Department;
import com.kreativstorm.hms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/department/{name}")
    public List<Department> getDepartmentsByName(@PathVariable("name") String name){
        return departmentService.getDepartmentsByName(name);
    }



}
