package com.cognicap.codemy.core.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.cognicap.codemy.core.persistence.domain.Seance;
import com.cognicap.codemy.core.persistence.domain.Session;

/**
 * Repository for {@link Seance}s
 * 
 */
@Repository
public class SeanceRepository {

	static final Logger logger = LoggerFactory
			.getLogger(SeanceRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllSeances() {
		List<Seance> results = mongoTemplate.findAll(Seance.class);
		logger.info("Total amount of Seances: {}", results.size());
		logger.info("Results Seances: {}");
		for(Seance p: results) {
			logger.info(""+p);
		}
	}

	public List<Seance> getAllSeances(String sessionId) {
		Session session=mongoTemplate.findById(sessionId, Session.class);
		return session.getSeances();
	}
	
	public void insertSeance(Seance p) {
		mongoTemplate.insert(p);
	}

	/**
	 * Create a {@link Seance} collection if the collection does not already
	 * exists
	 */
	public void createSeanceCollection() {
		if (!mongoTemplate.collectionExists(Seance.class)) {
			mongoTemplate.createCollection(Seance.class);
		}
	}

	/**
	 * Drops the {@link Seance} collection if the collection does already exists
	 */
	public void dropSeanceCollection() {
		if (mongoTemplate.collectionExists(Seance.class)) {
			mongoTemplate.dropCollection(Seance.class);
		}
	}
}