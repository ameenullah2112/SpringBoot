package com.ameen.sb.service;

import com.ameen.sb.data.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> eList = new ArrayList<>();
    private int idCounter;
    public Employee saveEmployee(Employee e){
        e.setId(++idCounter);
        eList.add(e);
        return e;
    }

    public List<Employee> getAllEmployees(){
        return eList;
    }

    public Employee getEmpById(int id){
        return eList.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public Employee updateEmployee(Employee e){
        Employee empById = getEmpById(e.getId());
        empById.setAddress(e.getAddress());
        empById.setName(e.getName());

        return empById;
    }
}
