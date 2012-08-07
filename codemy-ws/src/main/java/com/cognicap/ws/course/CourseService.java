package com.cognicap.ws.course;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.cognicap.codemy.core.persistence.domain.Course;

@WebService
public interface CourseService {
	List<Course> getCourses();
	Course getCourse(@WebParam(name="id") String id);
	Course getCourseByTitle(@WebParam(name="title") String title);

}
