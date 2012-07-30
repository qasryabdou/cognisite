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

/**
 * Repository for {@link Course}s
 * 
 */
@Repository
public class CourseRepository {

	static final Logger logger = LoggerFactory
			.getLogger(CourseRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllCourses() {
		List<Course> results = mongoTemplate.findAll(Course.class);
		logger.info("Total amount of Courses: {}", results.size());
		logger.info("Results Courses: {}");
		for (Course p : results) {
			logger.info("" + p);
		}
	}

	public List<Course> getAllCourses() {
		List<Course> results = mongoTemplate.findAll(Course.class);
		return results;
	}

	public Course getCourse(Long id) {
		Course course = mongoTemplate.findOne(new Query(Criteria.where("id")
				.is(id)), Course.class);
		return course;
	}

	public void insertCourse(Course p) {

		mongoTemplate.insert(p);

	}

	/**
	 * Create a {@link Course} collection if the collection does not already
	 * exists
	 */
	public void createCourseCollection() {
		if (!mongoTemplate.collectionExists(Course.class)) {
			mongoTemplate.createCollection(Course.class);
		}
	}

	/**
	 * Drops the {@link Course} collection if the collection does already exists
	 */
	public void dropCourseCollection() {
		if (mongoTemplate.collectionExists(Course.class)) {
			mongoTemplate.dropCollection(Course.class);
		}
	}
}