package com.cognicap.codemy.core.persistence.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cognicap.codemy.core.framework.Registration;

/**
 * A POJO representing a UserAccount
 * 
 */
@Document
public class UserAccount extends Registration {

	@Id
	private String userId;

	private String login;
	private String password;
	private String activationKey;
	private boolean activeAccount = false;
	private String role;

	public UserAccount() {
		super();
	}

	public UserAccount(String civilite, String nom, String prenom,
			String email, String mobile, String compagnie, String ville,
			String niveau, String referrant, String login, String password,
			boolean activeAccount, String role) {
		super(civilite, nom, prenom, email, mobile, compagnie, ville, niveau,
				referrant);
		this.login = login;
		this.password = password;
		this.activeAccount = activeAccount;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public boolean isActiveAccount() {
		return activeAccount;
	}

	public void setActiveAccount(boolean activeAccount) {
		this.activeAccount = activeAccount;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		String usr = getUserId() + "\n" + super.toString() + "\n" + getLogin()
				+ "\n" + getPassword() + "\n" + isActiveAccount() + "\n"
				+ getRole() + "\n";
		return usr;
	}

}