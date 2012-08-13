package com.cognicap.codemy.core.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.persistence.domain.Session;

/**
 * Repository for {@link Session}s
 * 
 */
@Repository
public class SessionRepository {

	static final Logger logger = LoggerFactory
			.getLogger(SessionRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllSessions() {
		List<Session> results = mongoTemplate.findAll(Session.class);
		logger.info("Total amount of Sessions: {}", results.size());
		logger.info("Results Sessions: {}");
		for(Session p: results) {
			logger.info(""+p);
		}
	}

	public List<Session> getAllSessions(String courseId) {
		Course course =mongoTemplate.findById(courseId, Course.class);
		return course.getSessions();
	}
<<<<<<< HEAD
	
=======
>>>>>>> b9581f0f830205b06da423634e64002af327a8ed
	public List<Session> getAllSessionsByTitle(String title) {
		Course course = mongoTemplate.findOne(new Query(Criteria.where("title")
				.is(title)), Course.class);
		return course.getSessions();
	}

	public void insertSession(Session p) {
		mongoTemplate.insert(p);
	}

	/**
	 * Create a {@link Session} collection if the collection does not already
	 * exists
	 */
	public void createSessionCollection() {
		if (!mongoTemplate.collectionExists(Session.class)) {
			mongoTemplate.createCollection(Session.class);
		}
	}

	/**
	 * Drops the {@link Session} collection if the collection does already exists
	 */
	public void dropSessionCollection() {
		if (mongoTemplate.collectionExists(Session.class)) {
			mongoTemplate.dropCollection(Session.class);
		}
	}
}