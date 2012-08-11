/*
 *  Cognicap Website
 *  Copyright (C) 2010 Cognicap SARL
 *  www.cognicap.com
 *
 *  Licensed under the GPL, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://gplv3.fsf.org/
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.cognicap.site.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognicap.site.service.SearchAutoCompleteService;
import com.cognicap.site.util.ResourcesUtil;
import com.cognicap.site.web.util.AutoCompleteResult;

@Controller
public class SearchAutoCompleteController {

	@Autowired
	SearchAutoCompleteService searchAutoCompleteService;

	private int maxSearchResults = Integer.parseInt(ResourcesUtil.getInstance()
			.getProperty("autocomplete_max_value_default"));

	static final Logger logger = LoggerFactory
			.getLogger(SearchAutoCompleteController.class);

	@RequestMapping(value = { "/globalSearchAutoComplete",
			"/globalSearchAutoComplete/*" }, method = RequestMethod.GET, headers = "Accept=*/*")
	@ResponseBody
	public List<AutoCompleteResult> autocompleteMav(
			@RequestParam(value = "term") String keyWord) {
		return searchAutoCompleteService.getData(keyWord, maxSearchResults);
	}
}