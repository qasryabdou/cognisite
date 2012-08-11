package com.cognicap.codemy.core.persistence.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A simple POJO representing a Person
 * 
 */
@Document
public class OrganizationMember extends Person {

	@Id
	private String id;

	private String title;

	public OrganizationMember(String title, String name, int age) {
		super(name, age);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}