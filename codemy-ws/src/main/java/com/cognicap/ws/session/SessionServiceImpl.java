package com.cognicap.ws.session;

import java.util.List;

import javax.jws.WebService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognicap.codemy.core.persistence.domain.Session;
import com.cognicap.codemy.core.repository.SessionRepository;

@WebService(endpointInterface="com.cognicap.ws.session.SessionService",name="seanceWebService")
public class SessionServiceImpl implements SessionService{

	public List<Session> getSessions(String courseId) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		SessionRepository sessionRepository = context
				.getBean(SessionRepository.class);
		
		return sessionRepository.getAllSessions(courseId);
	}
	
	public List<Session> getSessionsByTitle(String courseTitle) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		SessionRepository sessionRepository = context
				.getBean(SessionRepository.class);
		
		return sessionRepository.getAllSessionsByTitle(courseTitle);
	}
	

}