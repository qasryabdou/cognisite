package com.cognicap.ws;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognicap.codemy.core.persistence.domain.Seance;
import com.cognicap.codemy.core.repository.SeanceRepository;

public class SeanceServiceImpl implements SeanceService{

	public List<Seance> getSeances(String sessionId) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		SeanceRepository seanceRepository = context
				.getBean(SeanceRepository.class);
		
		return seanceRepository.getAllSeances(sessionId);
	}
	

}