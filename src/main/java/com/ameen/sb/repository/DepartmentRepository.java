package com.ameen.sb.repository;

import com.ameen.sb.data.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String deptName);

    Department getByCode(String deptCode);

    Department getByNameAndCode(String name, String code);

    List<Department> getByNameOrCode(String name, String code);
}
