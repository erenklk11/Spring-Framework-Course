package com.course.spring.spring_hibernate_jpa;

import com.course.spring.spring_hibernate_jpa.dao.StudentDAO;
import com.course.spring.spring_hibernate_jpa.entitiy.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//readStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Walker", "paul@luv2code.com");

		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		System.out.println("Generated ID: " + tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		int theID = 1;

		Student foundedStudent = studentDAO.findbyId(theID);

		if(foundedStudent != null){
			System.out.println("Student found!\n" + foundedStudent.toString());
		}
		else{
			System.out.println("Student not found!");
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> temp = studentDAO.findAll();

		for(Student student : temp){
			System.out.println(student);
		}
	}

	private void readStudentByLastName(StudentDAO studentDAO) {
		String lastName = "Walkerr";

		List <Student> foundedStudent = studentDAO.findByLastName(lastName);

		if(!foundedStudent.isEmpty()){
			System.out.println("Student found!\n" + foundedStudent.toString());
		}
		else{
			System.out.println("Student not found!");
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;

		Student temp = studentDAO.findbyId(id);

		if(temp != null){
			System.out.println("Student found!\nStudent being updated...");
			temp.setLast_name("Newman");
			studentDAO.update(temp);
		}
		else{
			System.out.println("Student not found!");
		}
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 1;

		Student temp = studentDAO.findbyId(id);

		if(temp != null){
			System.out.println("Student " + temp.getFirst_name() + " " + temp.getLast_name() + " has been deleted.");
			studentDAO.delete(id);
		}
		else{
			System.out.println("Student not found!");
		}

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowsAffected = studentDAO.deleteAll();

		System.out.println(rowsAffected + " rows have been deleted.");
	}

}
