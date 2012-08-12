package com.cognicap.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cognicap.codemy.core.persistence.domain.Course;

@Path("/course/")
public interface CourseService {
	@GET
	@Produces("application/json")
	@Path("All")
	List<Course> getCourses();
	@GET
	@Produces("application/json")
	@Path("id/{id}")
	Course getCourse(@PathParam("id") String id);
	@GET
	@Produces("application/json")
	@Path("title/{title}")
	Course getCourseByTitle(@PathParam("title") String title);

}
