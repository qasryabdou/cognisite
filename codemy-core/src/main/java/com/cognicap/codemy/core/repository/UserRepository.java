package com.cognicap.codemy.core.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cognicap.codemy.core.persistence.domain.UserAccount;

/**
 * Repository for {@link UserAccount}s
 * 
 */
@Repository
public class UserRepository {

	static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

	@Autowired
	MongoTemplate mongoTemplate;

	public void logAllUsers() {
		List<UserAccount> results = mongoTemplate.findAll(UserAccount.class);
		logger.info("Total amount of users: {}", results.size());
		logger.info("Results Users: {}");
		for (UserAccount u : results) {
			logger.info("" + u);
		}
	}

	public List<UserAccount> getAllUsers() {
		List<UserAccount> results = mongoTemplate.findAll(UserAccount.class);
		return results;
	}

	public void insertUser(UserAccount u) {
		mongoTemplate.insert(u);
	}

	/**
	 * Find a user in the User Collection using the login
	 */
	public UserAccount findUserByLogin(String login) {
		Query query = new Query(Criteria.where("login").is(login));
		UserAccount user = mongoTemplate.findOne(query, UserAccount.class);
		return user;
	}

	/**
	 * Find a user in the UserAccount Collection using the userId
	 */
	public UserAccount findUserByUserId(String id) {
		Query query = new Query(Criteria.where("userId").is(id));
		UserAccount user = mongoTemplate.findOne(query, UserAccount.class);
		return user;
	}

	/**
	 * Find a user in the UserAccount Collection using the userId
	 */
	public UserAccount findUserByKey(String key) {
		Query query = new Query(Criteria.where("activationKey").is(key));
		UserAccount user = mongoTemplate.findOne(query, UserAccount.class);
		return user;
	}

	public boolean activateUserAccount(String id) {
		Query query = new Query(Criteria.where("userId").is(id));
		Update update = new Update();
		update.set("activeAccount", true);
		UserAccount user = mongoTemplate.findAndModify(query, update,
				UserAccount.class);
		return user.isActiveAccount();
	}

	public UserAccount updateUserAccountById(UserAccount userAccount) {
		Query query = new Query(Criteria.where("userId").is(
				userAccount.getUserId()));
		Update update = new Update();
		update.set("civilite", userAccount.getCivilite());
		update.set("nom", userAccount.getNom());
		update.set("prenom", userAccount.getPrenom());
		update.set("email", userAccount.getEmail());
		update.set("mobile", userAccount.getMobile());
		update.set("compagnie", userAccount.getCompagnie());
		update.set("ville", userAccount.getVille());
		update.set("niveau", userAccount.getNiveau());
		update.set("referrant", userAccount.getReferrant());
		update.set("role", userAccount.getRole());
		UserAccount u = mongoTemplate.findAndModify(query, update,
				UserAccount.class);
		return u;

	}

	/**
	 * Create a {@link UserAccount} collection if the collection does not
	 * already exists
	 */
	public void createUserCollection() {
		if (!mongoTemplate.collectionExists(UserAccount.class)) {
			mongoTemplate.createCollection(UserAccount.class);
		}
	}

	/**
	 * Drops the {@link UserAccount} collection if the collection does already
	 * exists
	 */
	public void dropUserCollection() {
		if (mongoTemplate.collectionExists(UserAccount.class)) {
			mongoTemplate.dropCollection(UserAccount.class);
		}
	}
}