package com.cognicap.codemy.core.persistence.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@XmlRootElement(name="Session")
public class Session {
	
	@Id
	private String id;
	private String beginDate;
	private String endDate;
	private String instructor;	
	
	@DBRef
	private List<Seance> seances;
	
	@XmlTransient
	public List<Seance> getSeances() {
		return seances;
	}
	
	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	Session(){
		
	}
	public Session(String beginDate,String endDate,String instructor,List<Seance> seances){
		this.setBeginDate(beginDate);
		this.setEndDate(endDate);
		this.setInstructor(instructor);
		this.setSeances(seances);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
}
