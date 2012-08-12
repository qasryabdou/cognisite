package com.cognicap.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cognicap.codemy.core.persistence.domain.Session;

@Path("/session/")
public interface SessionService {
	@GET
	@Produces("application/json")
	@Path("byCourseId/{courseId}")
	public List<Session> getSessions(@PathParam("courseId") String courseId);
	@GET
	@Produces("application/json")
	@Path("byCourseTitle/{courseTitle}")
	public List<Session> getSessionsByTitle(@PathParam("courseTitle") String courseTitle);
}
