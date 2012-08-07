package com.cognicap.ws.course;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.repository.CourseRepository;

@WebService(endpointInterface="com.cognicap.ws.course.CourseService",name="courseWebService")
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
