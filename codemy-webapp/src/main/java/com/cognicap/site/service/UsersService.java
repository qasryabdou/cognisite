/*
 *  Cognicap Website
 *  Copyright (C) 2010 Cognicap SARL
 *  www.cognicap.com
 *
 *  Licensed under the GPL, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://gplv3.fsf.org/
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.cognicap.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.cognicap.codemy.core.persistence.domain.UserAccount;
import org.springframework.stereotype.Service;

import com.cognicap.codemy.core.repository.UserRepository;

/**
 * @version $Id$
 * @since 0.9
 */
@Service
public class UsersService {

	@Autowired
	UserRepository userRepository;

	public void loadDB() {

		userRepository.createUserCollection();

	}

	public List<UserAccount> getAllUsers() {
		return userRepository.getAllUsers();
	}

	public void insertUser(UserAccount u) {
		userRepository.insertUser(u);
	}

	public UserAccount findUserByLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

	public UserAccount findUserByUserId(String userId) {
		return userRepository.findUserByUserId(userId);
	}

	public UserAccount findUserByKey(String key) {
		return userRepository.findUserByKey(key);
	}

	public boolean activateUserAccount(String id) {
		return userRepository.activateUserAccount(id);
	}
}
