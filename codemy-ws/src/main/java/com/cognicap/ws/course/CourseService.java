package com.cognicap.ws.course;

import java.util.List;

import javax.jws.WebService;

import com.cognicap.codemy.core.persistence.domain.Course;

@WebService
public interface CourseService {
	List<Course> getCourses();

}
