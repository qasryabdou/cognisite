package com.cognicap.site.util;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognicap.codemy.core.persistence.domain.UserAccount;
import com.cognicap.site.service.UsersService;

public class ActivationKeyGenerator {

	public static final int LENGHT = 8;

	@Autowired
	UsersService usersService;

	/**
	 * Log4j logger that records events for this class
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ActivationKeyGenerator.class);

	/**
	 * validating the generated id
	 */
	public String validKey() {
		LOGGER.info("Generating a valid activation key.");
		String key = null;
		do {
			key = generateNewKey();
		} while (!isAvailableId(key));
		return key;
	}

	/**
	 * generating a random string of fixed lenght LENGHT.
	 */
	public String generateNewKey() {
		String rnd = RandomStringUtils.randomAlphanumeric(LENGHT);
		return rnd;
	}

	/**
	 * verifying the availability of the generated id.
	 */
	public boolean isAvailableId(String key) {
		UserAccount u = usersService.findUserByKey(key);
		boolean flag = false;
		if (u == null) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
}
