package com.course.spring.crud_project.dao;

import com.course.spring.crud_project.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
