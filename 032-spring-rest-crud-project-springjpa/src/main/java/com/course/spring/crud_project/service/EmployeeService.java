package com.course.spring.crud_project.service;

import com.course.spring.crud_project.entitiy.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void remove(int id);
}
