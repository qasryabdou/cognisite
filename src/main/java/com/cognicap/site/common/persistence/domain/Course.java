package com.cognicap.site.common.persistence.domain;

public class Course {
	private String id;
	private String title;
	private String desc;
	
	public Course() {
	}

	public Course(String id, String title, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
	}

	public String getId() {
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
