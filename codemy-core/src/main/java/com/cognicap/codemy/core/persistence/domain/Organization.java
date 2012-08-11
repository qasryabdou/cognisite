package com.cognicap.codemy.core.persistence.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * A simple POJO representing a Course
 * 
 */
@Document
public class Organization {
	
	@Id
	private String id;

	private String logo;

	@Indexed(sparse = true, unique=true)
	private String name;

	@Indexed(sparse = true, unique=true)
	private String email;
	private String url;
	private String location;
	private String description;
	
	
	public Organization(String name, String email, String url) {
		super();
		this.name = name;
		this.email = email;
		this.url = url;
	}

	@DBRef
	private List<OrganizationMember> members;
	
	@XmlTransient
	public List<OrganizationMember> getMembers() {
		return members;
	}
	
	public void setMembers(List<OrganizationMember> members) {
		this.members = members;
	}
    public Organization(){
    	
    }

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
