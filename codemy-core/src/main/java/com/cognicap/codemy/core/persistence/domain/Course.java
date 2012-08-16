package com.cognicap.codemy.core.persistence.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * A simple POJO representing a Course
 * 
 */
@Document
@XmlRootElement(name="Course")
public class Course {
	
	@Id
	private String id;

	private String icon;
	private String title;
	private String description;
	private String level;
	private String format;
	private String duration;
	private String objectif;
	private String prerequisite;
	
	
	@DBRef
	private List<Session> sessions;
	
	@XmlTransient
	public List<Session> getSessions() {
		return sessions;
	}
	
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
    public Course(){
    	
    }
	public Course(String title, String description,List<Session> sessions) {
		super();
		this.title = title;
		this.description = description;
		this.sessions=sessions;
	}
	 public Course(String icon, String title, String level,
	    		String format, String duration,String objectif, String prerequisite,
	    		String description){
	    	this.icon=icon;
	    	this.title=title;
	    	this.level=level;
	    	this.format=format;
	    	this.duration=duration;
	    	this.objectif=objectif;
	    	this.prerequisite=prerequisite;
	    	this.description=description;
	    }
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getObjectif() {
			return objectif;
		}

		public void setObjectif(String objectif) {
			this.objectif = objectif;
		}

		public String getPrerequisite() {
			return prerequisite;
		}

		public void setPrerequisite(String prerequisite) {
			this.prerequisite = prerequisite;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		
}
