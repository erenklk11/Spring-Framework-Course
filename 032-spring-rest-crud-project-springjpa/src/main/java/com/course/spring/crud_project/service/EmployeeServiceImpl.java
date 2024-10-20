package com.course.spring.crud_project.service;

import com.course.spring.crud_project.dao.EmployeeRepository;
import com.course.spring.crud_project.entitiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee temp = null;

        if(result.isPresent()){
            temp = result.get();
        }
        else{
            throw new RuntimeException("Student not found with id: " + id);
        }
        return temp;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }
}
