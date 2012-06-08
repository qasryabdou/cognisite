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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.cognicap.site.framework.Registration;
import com.cognicap.site.framework.notifications.RegistrationNotifier;

/**
 * @version $Id$
 * @since 0.1
 */

public class RegistrationController extends SimpleFormController {

	/**
	 * Log4j logger that records events for this class
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegistrationController.class);

	RegistrationNotifier registrationNotifier;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		Registration registration = (Registration) command;
		try {
			registrationNotifier.publish(registration);
		} catch (Exception ex) {
			LOGGER.error("Exception while publishing the registration.", ex);
			return new ModelAndView("erreurReception");
		}
		return new ModelAndView("confirmationReception");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		Registration command = new Registration();
		return command;
	}

	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		return !request.getParameterMap().isEmpty();
	}

	public void setRegistrationNotifier(
			RegistrationNotifier registrationNotifier) {
		this.registrationNotifier = registrationNotifier;
	}

	public RegistrationNotifier getRegistrationNotifier() {
		return this.registrationNotifier;
	}
}
