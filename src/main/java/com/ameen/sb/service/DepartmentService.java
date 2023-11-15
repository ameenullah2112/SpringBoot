package com.ameen.sb.service;

import com.ameen.sb.data.Department;
import com.ameen.sb.exception.NoRecordException;
import com.ameen.sb.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository repo;


    public Department saveDepartment(Department department){
        department.setCode(department.getName()+new Random().nextInt(1,10));
        return repo.save(department);
    }

    public List<Department> fetchDepartments() {
        return repo.findAll();
    }

    public Department getDepartment(int id) {
        Optional<Department> optional = repo.findById(id);
        if(!optional.isPresent()){
            throw new NoRecordException("Department not found for the id " + id);
        }
        return optional.get();
    }

    public Department updateDepartment(Department department) {
        Department oldDept = repo.findById(department.getId()).get();
        oldDept.setAddress(department.getAddress());
        oldDept.setCode(department.getCode());
        oldDept.setName(department.getName());
        return repo.save(oldDept);
    }

    public void deleteDepartment(int id) {
        repo.deleteById(id);
    }

    public Department getDepartmentByName(String deptName) {
        return repo.findByName(deptName);
    }

    public Department getDepartmentByCode(String deptCode) {
        return repo.getByCode(deptCode);
    }

    public Department getDepartmentByNameAndCode(String deptName, String deptCode) {
        return repo.getByNameAndCode(deptName, deptCode);
    }

    public List<Department> getDepartmentByNameOrCode(String deptName, String deptCode) {
        return repo.getByNameOrCode(deptName, deptCode);
    }
}
