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

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.cognicap.site.framework.Registration;
import com.cognicap.site.web.controllers.RegistrationController;

/**
 * @version $Id$
 * @since 0.9
 */
@ContextConfiguration(locations = { "classpath:/test-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ReservationControllerTest {
	
	/**
	 * Log4j logger that records events for this class
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReservationControllerTest.class);

	@Autowired
	private RegistrationController controller;

	@Autowired
	private Registration registration;

	@Test
	public void testSubmitForm() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setMethod("GET");
		
		ModelAndView mav = null;
		try {
			mav = controller.onSubmit(request, response, registration, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.debug(mav.getViewName());
		assertEquals("confirmationReception", mav.getViewName());
	}
}