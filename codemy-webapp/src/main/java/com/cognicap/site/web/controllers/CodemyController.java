package com.cognicap.site.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CodemyController {
	static final Logger logger = LoggerFactory
			.getLogger(CodemyController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView codemyStart() {
		return new ModelAndView("main");
	}

	@RequestMapping(value = { "/About" }, method = RequestMethod.GET)
	public ModelAndView about() {
		return new ModelAndView("about");
	}

	@RequestMapping(value = { "/Trainings" }, method = RequestMethod.GET)
	public ModelAndView trainings() {
		return new ModelAndView("formations");
	}
}