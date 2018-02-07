package com.skcc.dataanalysis.woolim.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;


import com.skcc.dataanalysis.HomeController;
import com.skcc.dataanalysis.woolim.service.WoolimService;
import com.skcc.dataanalysis.woolim.vo.WoolimVO;

@Controller
public class WoolimController {
	
	@Autowired
	private WoolimService woolimService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/woolim", method = RequestMethod.GET)
	public String woolim(Locale locale, Model model) {
		return "woolim";
	}
	
	@RequestMapping(value = "/woolimTest.do", method = RequestMethod.POST)
	public String woolimTest(Locale locale, Model model, WoolimVO woolimVO) {
		
		woolimService.woolimTest(woolimVO);
		
		return "woolim";
	}

}
