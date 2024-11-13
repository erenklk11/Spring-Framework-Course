package com.course.spring.jpa_advanced_mappings;

import com.course.spring.jpa_advanced_mappings.dao.AppDAO;
import com.course.spring.jpa_advanced_mappings.entitiy.Course;
import com.course.spring.jpa_advanced_mappings.entitiy.Instructor;
import com.course.spring.jpa_advanced_mappings.entitiy.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaAdvancedMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
		};
	}



	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("erenklk11@gmail.com", "Eren", "Kalkan");
		InstructorDetail tempInstructorDetail = new InstructorDetail("going to the gym", "http://www.youtube.com");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done.");
	}


	private void findInstructor(AppDAO appDAO) {

		int id = 1;

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("Instructor found! \n" + tempInstructor);
		System.out.println("The associated instructorDetail: " + tempInstructor.getInstructorDetail());
	}


	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Deleting instructor by id = 1");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int id = 1;

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor Detail: " + tempInstructorDetail);
		System.out.println("Instructor: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 1;

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Deleting Instructor Detail with id: " + id);
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}


}
