package com.cognicap.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cognicap.codemy.core.persistence.domain.Seance;

@Path("/seance/")
public interface SeanceService {
	@GET
	@Produces("application/json")
	@Path("bySessionId/{sessionId}")
	public List<Seance> getSeances(@PathParam("sessionId") String sessionId);
}
