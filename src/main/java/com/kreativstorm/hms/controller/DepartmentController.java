package com.kreativstorm.hms.controller;

import com.kreativstorm.hms.entities.Department;
import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/{name}")
    public List<Department> getDepartmentsByName(@PathVariable("name") String name){
        return departmentService.getDepartmentsByName(name);
    }

    @PostMapping("/save")
    void addDepartment(@RequestBody @Valid Department department){
        departmentService.saveDepartment(department);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Department> upadateDepartment(@PathVariable("id") Integer id,
                                                              @Valid @RequestBody Department department){
        Optional<Department> department1 = departmentService.update(id, department);
        if(department1.isEmpty()){
            throw new ClientException("Department Not Found");
        }
        return new ResponseEntity<>(department1.get(), HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        departmentService.deleteDepartment(id);
    }

    @PutMapping("/add-patient/{id}")
    public ResponseEntity<Department> addPatient(@PathVariable("id") Integer id,
                                                        @Valid @RequestBody Department department){
        Optional<Department> department1 = departmentService.addPatient(id, department);
        if(department1.isEmpty()){
            throw new ClientException("Department Not Found");
        }
        return new ResponseEntity<>(department1.get(), HttpStatus.OK);
    }

    @PutMapping("/add-staff/{id}")
    public ResponseEntity<Department> addStaff(@PathVariable("id") Integer id,
                                                 @Valid @RequestBody Department department){
        Optional<Department> department1 = departmentService.addStaff(id, department);
        if(department1.isEmpty()){
            throw new ClientException("Department Not Found");
        }
        return new ResponseEntity<>(department1.get(), HttpStatus.OK);
    }

    @PutMapping("/remove-patient/{id}")
    public ResponseEntity<Department> removePatient(@PathVariable("id") Integer id,
                                                 @Valid @RequestBody Department department){
        Optional<Department> department1 = departmentService.removePatient(id, department);
        if(department1.isEmpty()){
            throw new ClientException("Department Not Found");
        }
        return new ResponseEntity<>(department1.get(), HttpStatus.OK);
    }

    @PutMapping("/remove-staff/{id}")
    public ResponseEntity<Department> removeStaff(@PathVariable("id") Integer id,
                                                    @Valid @RequestBody Department department){
        Optional<Department> department1 = departmentService.removeStaff(id, department);
        if(department1.isEmpty()){
            throw new ClientException("Department Not Found");
        }
        return new ResponseEntity<>(department1.get(), HttpStatus.OK);
    }

}
