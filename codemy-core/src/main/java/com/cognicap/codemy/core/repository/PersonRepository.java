package com.cognicap.codemy.core.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cognicap.codemy.core.persistence.domain.Person;

/**
 * Repository for {@link Person}s
 * 
 */
@Repository
public class PersonRepository {

	static final Logger logger = LoggerFactory
			.getLogger(PersonRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllPersons() {
		List<Person> results = mongoTemplate.findAll(Person.class);
		logger.info("Total amount of persons: {}", results.size());
		logger.info("Results Persons: {}");
		for (Person p : results) {
			logger.info("" + p);
		}
	}

	public List<Person> getAllPersons() {
		Query query = new Query(Criteria.where("name").is("John"));
		logger.info("Executing Query: Criteria.where(name).is(John)");
		query.sort().on("age", Order.DESCENDING);
		logger.info("Executing query: query.sort().on(age, Order.DESCENDING)");
		List<Person> results = mongoTemplate.find(query, Person.class);
		logger.info("Total amount of persons: {}", results.size());
		return results;
	}

	public void insertPersonWithNameJohnAndRandomAge() {
		// get random age between 1 and 100
		double age = Math.ceil(Math.random() * 100);

		Person p = new Person("John", (int) age);

		mongoTemplate.insert(p);
	}

	/**
	 * Create a {@link Person} collection if the collection does not already
	 * exists
	 */
	public void createPersonCollection() {
		if (!mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.createCollection(Person.class);
		}
	}

	/**
	 * Drops the {@link Person} collection if the collection does already exists
	 */
	public void dropPersonCollection() {
		if (mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.dropCollection(Person.class);
		}
	}
}