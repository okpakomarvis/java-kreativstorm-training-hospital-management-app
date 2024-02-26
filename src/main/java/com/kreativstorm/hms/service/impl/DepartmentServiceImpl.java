package com.kreativstorm.hms.service.impl;

import com.kreativstorm.hms.entities.Department;
import com.kreativstorm.hms.entities.MedicalReport;
import com.kreativstorm.hms.entities.Users;
import com.kreativstorm.hms.exception.ClientException;
import com.kreativstorm.hms.repositories.DepartmentRepository;
import com.kreativstorm.hms.repositories.UsersRepository;
import com.kreativstorm.hms.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartmentsByName(String name){
        return  departmentRepository.getDepartmentsByNameContainingIgnoreCase(name);
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Integer departmentID) {
        Optional<Department> department  = departmentRepository.findById(departmentID);
        if(department.isEmpty()){
            throw new ClientException("Department does not exist");
        }else {
            departmentRepository.deleteById(departmentID);
        }
    }

    @Override
    public Optional<Department> update(int id, Department department) {
        Department department1 = new Department();
        department1.setId((long) id);
        department1.setName(department.getName());
        department1.setPatients(department.getPatients());
        department1.setStaff(department.getStaff());
        return Optional.of(departmentRepository.saveAndFlush(department1));
    }

    @Override
    public Optional<Department> addPatient(Integer patientID, Department department) {
        Department department1 = new Department();
        department1.setName(department.getName());
        department1.setStaff(department.getStaff());
        List<Users> users =  department.getPatients();
        Optional<Users> user = usersRepository.findById((long) patientID);
        users.add(user.get());
        department1.setPatients(users);
        return Optional.of(departmentRepository.saveAndFlush(department1));
    }

    @Override
    public Optional<Department> addStaff(Integer staffID, Department department) {
        Department department1 = new Department();
        department1.setName(department.getName());
        department1.setPatients(department.getPatients());
        List<Users> users =  department.getPatients();
        Optional<Users> user = usersRepository.findById((long) staffID);
        users.add(user.get());
        department1.setStaff(users);
        return Optional.of(departmentRepository.saveAndFlush(department1));
    }

    @Override
    public Optional<Department> removePatient(Integer patientID, Department department) {
        Department department1 = new Department();
        department1.setName(department.getName());
        department1.setStaff(department.getStaff());
        List<Users> users =  department.getPatients();
        Optional<Users> user = usersRepository.findById((long) patientID);
        users.remove(user.get());
        department1.setPatients(users);
        return Optional.of(departmentRepository.saveAndFlush(department1));
    }

    @Override
    public Optional<Department> removeStaff(Integer staffID, Department department) {
        Department department1 = new Department();
        department1.setName(department.getName());
        department1.setPatients(department.getPatients());
        List<Users> users =  department.getPatients();
        users.remove(usersRepository.findById((long)staffID));
        department1.setStaff(users);
        return Optional.of(departmentRepository.saveAndFlush(department1));    }
}
