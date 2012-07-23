package com.cognicap.ws.seance;

import java.util.List;

import javax.jws.WebService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognicap.codemy.core.persistence.domain.Seance;
import com.cognicap.codemy.core.repository.SeanceRepository;

@WebService(endpointInterface="com.cognicap.ws.seance.SeanceService",name="seanceWebService")
public class SeanceServiceImpl implements SeanceService{

	public List<Seance> getSeances(String sessionId) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		SeanceRepository seanceRepository = context
				.getBean(SeanceRepository.class);
		
		return seanceRepository.getAllSeances(sessionId);
	}
	

}