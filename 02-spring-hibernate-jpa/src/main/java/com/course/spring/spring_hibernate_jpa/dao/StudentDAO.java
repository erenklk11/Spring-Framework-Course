package com.course.spring.spring_hibernate_jpa.dao;

import com.course.spring.spring_hibernate_jpa.entitiy.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findbyId(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Integer id);
    int deleteAll();

}
