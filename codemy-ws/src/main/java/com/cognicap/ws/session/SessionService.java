package com.cognicap.ws.session;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.cognicap.codemy.core.persistence.domain.Session;

@WebService
public interface SessionService {
	public List<Session> getSessions(@WebParam(name="courseId") String courseId);
}
