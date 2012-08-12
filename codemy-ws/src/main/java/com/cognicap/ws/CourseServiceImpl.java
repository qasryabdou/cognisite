package com.cognicap.ws;

import java.util.List;

import javax.jws.WebParam;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.repository.CourseRepository;

public class CourseServiceImpl implements CourseService{
	public List<Course> getCourses() {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		CourseRepository courseRepository = context
				.getBean(CourseRepository.class);
		
		return courseRepository.getAllCourses();
	}
	
	public Course getCourse(String id) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		CourseRepository courseRepository = context
				.getBean(CourseRepository.class);
		
		return courseRepository.getCourse(id);
	}

	public Course getCourseByTitle(@WebParam(name = "title") String title) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		CourseRepository courseRepository = context
				.getBean(CourseRepository.class);
		
		return courseRepository.getCourseByTitle(title);
	}
	

}
