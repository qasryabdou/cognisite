package com.cognicap.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.repository.CourseRepository;

@Service
public class AutocompleteService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public String autocompleteData(){
		
		String courses ="[";
		List<Course> x =courseRepository.getAllCourses();
		System.out.println(x.isEmpty());
		for (int i = 0; i < x.size()-1; i++) {
			courses+="\""+x.get(i).getTitle()+"\",";
		} 
		courses+="\""+x.get(x.size()-1).getTitle()+"\"]";
		
		//Gson gson = new Gson();
		return courses;
	}
	
}
