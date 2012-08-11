package com.cognicap.site.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognicap.codemy.core.persistence.domain.Course;
import com.cognicap.codemy.core.repository.CourseRepository;
import com.cognicap.site.web.util.AutoCompleteResult;

@Service
public class SearchAutoCompleteService {

	static final Logger logger = LoggerFactory
			.getLogger(SearchAutoCompleteService.class);

	@Autowired
	CourseRepository courseRepository;

	public List<AutoCompleteResult> getData(String keyWord, int maxSearchResults) {

		List<Course> searchItems = courseRepository.searchCourses(keyWord, maxSearchResults);
		List<AutoCompleteResult> results = new ArrayList<AutoCompleteResult>();

		logger.info("Empty search result: " + searchItems.isEmpty());
		
		if (searchItems.isEmpty())
			return results;

		for (Course c : searchItems) {
			results.add(new AutoCompleteResult(c.getId(), c.getTitle()));
		}

		logger.info(results.toString());
		
		return results;
	}

}
