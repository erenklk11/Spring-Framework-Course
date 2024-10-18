package com.course.spring.rest.rest;

import com.course.spring.rest.entitiy.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List <Student> students;

    @PostConstruct
    public void initStudents(){

        students = new ArrayList();

        students.add(new Student("Mark Cuban", 0));
        students.add(new Student("Elon Musk", 1));
        students.add(new Student("Jeff Bezos", 1));
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if(studentId < 0 || studentId >= students.size()){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
    
}
