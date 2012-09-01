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
package com.cognicap.codemy.core.framework;

/**
 * @version $Id$
 * @since 0.2
 */
public class Registration {

	private String civilite;
	private String nom;
	private String prenom;
	private String email;
	private String mobile;
	private String compagnie;
	private String ville;
	private String niveau;
	private String referrant;

	public Registration() {

	}

	public Registration(String civilite, String nom, String prenom,
			String email, String mobile, String compagnie, String ville,
			String niveau, String referrant) {
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mobile = mobile;
		this.compagnie = compagnie;
		this.ville = ville;
		this.niveau = niveau;
		this.referrant = referrant;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getReferrant() {
		return referrant;
	}

	public void setReferrant(String referrant) {
		this.referrant = referrant;
	}

	public String toString() {
		String reg = getCivilite() + "\n" + getNom() + "\n" + getPrenom()
				+ "\n" + getEmail() + "\n" + getMobile() + "\n"
				+ getCompagnie() + "\n" + getVille() + "\n" + getNiveau()
				+ "\n" + getReferrant() + "\n";
		return reg;
	}
}