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
package com.cognicap.site.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DocumentFactory {

	/**
	 * Log4j logger that records events for this class
	 */
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public enum DocumentType {
		VCARD
	}

	public static DocumentFactory getFactory(DocumentType dt) {
		switch (dt) {
		case VCARD:
			return new VCardFactory();
		default:
			return null;
		}
	}

	public abstract Document createDocument(IContact c);
}
