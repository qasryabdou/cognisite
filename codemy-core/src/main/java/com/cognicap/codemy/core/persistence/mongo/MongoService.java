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
package com.cognicap.codemy.core.persistence.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.Mongo;

public class MongoService {
	private Mongo mongo = null;

	private String hostname;
	private Integer port;
	private String dbName;

	/**
	 * Log4j logger that records events for this class
	 */
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public MongoService(String hostname, Integer port, String dbName) {
		this.hostname = hostname;
		this.port = port;
		this.dbName = dbName;
		this.mongo = this.getInstance(hostname, port, dbName);
	}

	public Mongo getMongo() {
		if (mongo == null) {
			this.mongo = getInstance(hostname, port, dbName);
		}
		return mongo;
	}

	public DB getDB() {
		return mongo.getDB(this.dbName);
	}

	private Mongo getInstance(String hostname, Integer port, String dbName) {
		try {
			mongo = new Mongo(new DBAddress(hostname + ":" + port, dbName));
		} catch (Exception e) {
			LOGGER.info("Unable to make connection to mongo db", e);
		}
		return mongo;
	}
}
