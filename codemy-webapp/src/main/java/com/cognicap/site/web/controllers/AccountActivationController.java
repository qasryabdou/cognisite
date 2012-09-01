package com.cognicap.site.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognicap.codemy.core.persistence.domain.UserAccount;
import com.cognicap.site.service.UsersService;

@Controller
public class AccountActivationController {
	@Autowired
	UsersService usersService;

	static final Logger logger = LoggerFactory
			.getLogger(AccountActivationController.class);

	@RequestMapping(value = { "/AccountActivation", "/AccountActivation/*" }, method = RequestMethod.GET)
	public ModelAndView activateAccount(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		String key = request.getParameter("key");

		System.out.println(key);

		UserAccount ua = usersService.findUserByKey(key);
		usersService.activateUserAccount(ua.getUserId());
		ua = usersService.findUserByKey(key);
		if (ua != null) {
			if (ua.isActiveAccount()) {
				mav.setViewName("registration/accountActivationSuccess");
			} else {
				mav.setViewName("registration/accountActivationFail");
			}
		}
		return mav;
	}
}
