package com.ameen.sb.controller;

import com.ameen.sb.data.Department;
import com.ameen.sb.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping
    Department createDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    List<Department> fetchDepartments(){
        return departmentService.fetchDepartments();
    }

    @GetMapping("/{id}")
    Department getDepartment(@PathVariable("id") int id){
        return departmentService.getDepartment(id);
    }

    @PutMapping("/{id}")
    Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    String deleteDepartment(@PathVariable("id") int id){
        departmentService.deleteDepartment(id);
        return "Deleted";
    }

    @GetMapping("/name/{name}")
    Department getDepartmentByName(@PathVariable("name") String deptName){
        return departmentService.getDepartmentByName(deptName);
    }

    @GetMapping("/code/{code}")
    Department getDepartmentByCode(@PathVariable("code") String deptCode){
        return departmentService.getDepartmentByCode(deptCode);
    }

    @GetMapping("/name/{name}/code/{code}")
    List<Department> getDepartmentByNameOrCode(@PathVariable("name") String deptName, @PathVariable("code") String deptCode){
        return departmentService.getDepartmentByNameOrCode(deptName, deptCode);
    }
}
