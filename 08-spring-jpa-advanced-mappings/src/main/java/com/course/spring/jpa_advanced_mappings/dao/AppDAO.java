package com.course.spring.jpa_advanced_mappings.dao;

import com.course.spring.jpa_advanced_mappings.entitiy.Instructor;
import com.course.spring.jpa_advanced_mappings.entitiy.InstructorDetail;

public interface AppDAO {


    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
