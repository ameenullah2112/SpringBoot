package com.ameen.sb.controller;

import com.ameen.sb.data.Employee;
import com.ameen.sb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    EmployeeService es;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return es.getEmpById(id);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return es.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee e) {
        System.err.println("creating employee");
        return es.saveEmployee(e);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee e) {
        return es.updateEmployee(e);
    }


}
