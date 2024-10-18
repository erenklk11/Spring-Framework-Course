package com.course.spring.crud_project.dao;

import com.course.spring.crud_project.entitiy.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeJpaDAOImpl implements EmployeeDAO {

    private EntityManager entitiyManager;

    @Autowired
    public EmployeeJpaDAOImpl(EntityManager entitiyManager) {
        this.entitiyManager = entitiyManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> findAllQuery = entitiyManager.createQuery("FROM Employee", Employee.class);

        return findAllQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entitiyManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        Employee savedEmployee = entitiyManager.merge(employee);

        return savedEmployee;
    }

    @Override
    @Transactional
    public void remove(int id) {

        Employee temp = entitiyManager.find(Employee.class, id);

        entitiyManager.remove(temp);

    }
}
