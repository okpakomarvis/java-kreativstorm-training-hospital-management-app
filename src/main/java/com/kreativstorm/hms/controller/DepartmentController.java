package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Department;
import com.kreativstorm.hms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
<<<<<<< HEAD
@RequestMapping("hms")
@CrossOrigin(origins = "http://localhost:4200")
=======
@RequestMapping("/api/v1/departments")
>>>>>>> 894f12e529360fca67f1c58310f63373596da94d
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
