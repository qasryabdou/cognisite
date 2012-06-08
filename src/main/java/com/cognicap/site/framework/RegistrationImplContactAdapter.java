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

import com.cognicap.site.framework.Registration;

/**
 * @version $Id$
 * @since 0.2
 */
public class RegistrationImplContactAdapter implements IContact {
	private Registration registration;

	public RegistrationImplContactAdapter(Registration reg) {
		this.registration = reg;
	}

	public String getNom() {
		return this.registration.getNom();
	}

	public void setNom(String nom) {
		this.registration.setNom(nom);
	}

	public String getPrenom() {
		return this.registration.getPrenom();
	}

	public void setPrenom(String prenom) {
		this.registration.setPrenom(prenom);
	}

	public String getEmail() {
		return this.registration.getEmail();
	}

	public void setEmail(String email) {
		this.registration.setEmail(email);
	}

	public String getMobile() {
		return this.registration.getMobile();
	}

	public void setMobile(String mobile) {
		this.registration.setMobile(mobile);
	}

	public String getCompagnie() {
		return this.registration.getCompagnie();
	}

	public void setCompagnie(String compagnie) {
		this.registration.setCompagnie(compagnie);
	}

	public String getVille() {
		return this.registration.getVille();
	}

	public void setVille(String ville) {
		this.registration.setVille(ville);
	}
}
