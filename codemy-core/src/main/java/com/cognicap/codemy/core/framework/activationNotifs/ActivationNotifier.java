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
package com.cognicap.codemy.core.framework.activationNotifs;

import java.util.ArrayList;

import com.cognicap.codemy.core.persistence.domain.UserAccount;

/**
 * @version $Id$
 * @since 0.9
 */
public class ActivationNotifier {
	private ArrayList<ActivationNotification> observersList = new ArrayList<ActivationNotification>();
	
	public void addObserver(ActivationNotification rn) {
		observersList.add(rn);
	}
	
	public boolean removeObserver(ActivationNotification rn) {
		return observersList.remove(rn);
	}
	
	/**
	 * Publish the new registration to all observers
	 * @param registration
	 * @throws Exception
	 */
	public void sendActivationMail(UserAccount ua) throws Exception {
		//TODO: Exception has to be caught and queued so the notification process is not blocked.
		for (ActivationNotification rn: observersList) {
			rn.notifyActivation(ua);
		}
	}
}