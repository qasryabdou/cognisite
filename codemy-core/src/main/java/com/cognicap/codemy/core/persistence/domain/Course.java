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
	private String title;
	private String level;
	private String format;
	private String duration;
	private String obj;
	private String prereq;
	private String desc;
	
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
	public Course(String title, String desc,List<Session> sessions) {
		super();
		this.title = title;
		this.desc = desc;
		this.sessions=sessions;
	}
	public  String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
