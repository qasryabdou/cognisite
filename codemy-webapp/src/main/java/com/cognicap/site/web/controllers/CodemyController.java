package com.cognicap.site.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognicap.site.service.CourseService;

@Controller
public class CodemyController {

	@Autowired
	CourseService courseService;

	static final Logger logger = LoggerFactory
			.getLogger(CodemyController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView codemyStart() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = { "/About" }, method = RequestMethod.GET)
	public ModelAndView about() {
		return new ModelAndView("about");
	}

	@RequestMapping(value = { "/Test" }, method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test");
		courseService.loadDB();
		mav.addObject("courses", courseService.getAllCourses());
		return mav;
	}

	@RequestMapping(value = { "/Trainings" }, method = RequestMethod.GET)
	public ModelAndView trainings() {
		return new ModelAndView("formations");
	}
}