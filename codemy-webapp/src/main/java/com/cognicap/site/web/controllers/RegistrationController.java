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
package com.cognicap.site.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognicap.codemy.core.framework.Registration;
import com.cognicap.codemy.core.framework.activationNotifs.ActivationNotifier;
import com.cognicap.codemy.core.framework.notifications.RegistrationNotifier;
import com.cognicap.codemy.core.persistence.domain.UserAccount;
import com.cognicap.site.service.UsersService;
import com.cognicap.site.util.ActivationKeyGenerator;
import com.cognicap.site.util.PasswordEncrypter;

/**
 * @version $Id$
 * @since 0.1
 */

@Controller
public class RegistrationController {

	/**
	 * Log4j logger that records events for this class
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegistrationController.class);

	@Autowired
	RegistrationNotifier registrationNotifier;

	@Autowired
	ActivationNotifier activationNotifier;

	@Autowired
	UsersService usersService;

	@RequestMapping(value = "/Registration", method = RequestMethod.GET)
	protected ModelAndView doGet(ModelMap model) {

		LOGGER.info("New registration page requested.");
		UserAccount user = new UserAccount();
		model.addAttribute("USER", user);
		return new ModelAndView("inscription");
	}

	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	protected ModelAndView onSubmit(
			@ModelAttribute(value = "USER") UserAccount user,
			BindingResult result) {

		Registration registration = new Registration(user.getCivilite(),
				user.getNom(), user.getPrenom(), user.getEmail(),
				user.getMobile(), user.getCompagnie(), user.getVille(),
				user.getNiveau(), user.getReferrant());

		LOGGER.info("New registration received.\n" + registration);

		ActivationKeyGenerator akg = new ActivationKeyGenerator();
		PasswordEncrypter pe = new PasswordEncrypter();

		user.setActivationKey(akg.generateNewKey());
		user.setPassword(pe.encryptToMD5(user.getPassword()));
		user.setRole("ROLE_USER");

		usersService.insertUser(user);

		LOGGER.info("New userAccount Created.\n" + user);

		try {
			activationNotifier.sendActivationMail(user);
			registrationNotifier.publish(registration);
		} catch (Exception ex) {
			LOGGER.error("Exception while sending the Activation mail.", ex);
			LOGGER.error("Exception while publishing the registration.", ex);
			return new ModelAndView("registration/erreurEnvoiMail");
		}
		return new ModelAndView("registration/confirmationEnvoiMail");
	}

	public void setRegistrationNotifier(
			RegistrationNotifier registrationNotifier) {
		this.registrationNotifier = registrationNotifier;
	}

	public RegistrationNotifier getRegistrationNotifier() {
		return this.registrationNotifier;
	}

	public ActivationNotifier getActivationNotifier() {
		return activationNotifier;
	}

	public void setActivationNotifier(ActivationNotifier activationNotifier) {
		this.activationNotifier = activationNotifier;
	}

}
