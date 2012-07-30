/*
* Cognicap Website
* Copyright (C) 2010 Cognicap SARL
* www.cognicap.com
*
* Licensed under the GPL, Version 3.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://gplv3.fsf.org/
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.cognicap.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.repository.CourseRepository;

/**
* @version $Id$
* @since 0.9
*/
@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	public void loadDB() {
		// get random int between 1 and 100
		double i = Math.ceil(Math.random() * 100);
		//courseRepository.dropCourseCollection();
		courseRepository.insertCourse( new Course("/cognicap.com/img/logo-java.png","intitule ceci est un test</br>et continue le test"+i,  "format"+i,"duree"+i,  "niveau"+i,  "objectif"+i, "prereq"+i,  "description"+i));
		
	}
	
	public List<Course> getAllCourses() {
		return courseRepository.getAllCourses();
	}

}