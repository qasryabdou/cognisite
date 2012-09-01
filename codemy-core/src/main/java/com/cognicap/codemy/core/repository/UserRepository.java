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

	public void insertUserWithRandomInfos() {
		// get random age between 1 and 100
		double i = Math.ceil(Math.random() * 100);
		UserAccount u1 = new UserAccount("Mr.", "firstname", "lastname",
				"abdou@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "abdou", "password", true, "role");
		UserAccount u2 = new UserAccount("Mr.", "firstname", "lastname",
				"anouar@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "anouar", "password", true, "role");
		UserAccount u3 = new UserAccount("Mr.", "firstname", "lastname",
				"abdellah@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "abdellah", "password", true, "role");
		UserAccount u4 = new UserAccount("Mr.", "firstname", "lastname",
				"nabil@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "nabil", "password", true, "role");
		UserAccount u5 = new UserAccount("Mr.", "firstname", "lastname",
				"yassin@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "yassine", "password", true, "role");
		UserAccount u6 = new UserAccount("Mr.", "firstname", "lastname",
				"mehdi@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "mehdi", "password", true, "role");
		UserAccount u7 = new UserAccount("Mlle.", "firstname", "lastname",
				"sara@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "sara", "password", true, "role");
		UserAccount u8 = new UserAccount("Mlle.", "firstname", "lastname",
				"hibat@cognicap.com", "mobile", "comp", "ville", "niveau",
				"referrant", "hibat", "password", true, "role");

		mongoTemplate.insert(u1);
		mongoTemplate.insert(u2);
		mongoTemplate.insert(u3);
		mongoTemplate.insert(u4);
		mongoTemplate.insert(u5);
		mongoTemplate.insert(u6);
		mongoTemplate.insert(u7);
		mongoTemplate.insert(u8);
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