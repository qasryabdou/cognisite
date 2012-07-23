package com.cognicap.ws.seance;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.cognicap.codemy.core.persistence.domain.Seance;

@WebService
public interface SeanceService {
	public List<Seance> getSeances(@WebParam(name="sessionId") String sessionId);
}
