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

import com.cognicap.codemy.core.persistence.domain.Organization;
import com.cognicap.codemy.core.persistence.domain.Person;

/**
 * Repository for {@link Organization}
 * 
 */
@Repository
public class OrganizationRepository {

	static final Logger logger = LoggerFactory
			.getLogger(OrganizationRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public List<Organization> getAllOrganization() {
		List<Organization> results = mongoTemplate.findAll(Organization.class);
		return results;
	}

	public void insertOrganization(Organization o) {
		mongoTemplate.insert(o);
	}
	
	public Organization getOrganizationById(long orgId) {
		Organization org =mongoTemplate.findById(orgId, Organization.class);
		return org;
	}
	
	public Organization getOrganizationByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		Organization org = mongoTemplate.findOne(query, Organization.class);
		return org;
	}

	/**
	 * Create a {@link Organization} collection if the collection does not already
	 * exists
	 */
	public void createOrganizationCollection() {
		if (!mongoTemplate.collectionExists(Organization.class)) {
			mongoTemplate.createCollection(Organization.class);
		}
	}

	/**
	 * Drops the {@link Organization} collection if the collection does already exists
	 */
	public void dropOrganizationCollection() {
		if (mongoTemplate.collectionExists(Organization.class)) {
			mongoTemplate.dropCollection(Organization.class);
		}
	}
}