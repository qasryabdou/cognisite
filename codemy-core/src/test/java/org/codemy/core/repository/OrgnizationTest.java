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
package org.codemy.core.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognicap.codemy.core.persistence.domain.Organization;
import com.cognicap.codemy.core.repository.OrganizationRepository;

/**
 * @version $Id$
 * @since 0.9
 */
@ContextConfiguration(locations = { "classpath:*applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OrgnizationTest {

	/**
	 * Log4j logger that records events for this class
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrgnizationTest.class);

	@Autowired
	private OrganizationRepository repository;

	@Test
	public void testOrgCreation() {

		Organization org = new Organization("Cognicap", "contact@cognicap.com","www.codemy.com");
		LOGGER.debug(org.getName());		
		repository.insertOrganization(org);
		org = repository.getOrganizationByName("Cognicap");		
		assertEquals("contact@cognicap.com", org.getEmail());
		assertEquals("www.codemy.com", org.getUrl());
	}
}
