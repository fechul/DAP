package com.skcc.dataanalysis.retrieve.controller;

import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skcc.dataanalysis.retrieve.service.RetrieveService;

@Controller
public class RetrieveController {

	@Autowired
	private RetrieveService retrieveService;
	
	@RequestMapping(value = "/retrieve/gender", method = RequestMethod.GET)
	public JSONArray retrieveGender(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getGender();
		
		return jsonArray;
	}
	
	
	@RequestMapping(value = "/retrieve/age", method = RequestMethod.GET)
	public JSONArray retrieveAge(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getAge();
		
		return jsonArray;
	}
	
	@RequestMapping(value = "/retrieve/major", method = RequestMethod.GET)
	public JSONArray retrieveMajor(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getMajor();
		
		return jsonArray;
	}
	
	@RequestMapping(value = "/retrieve/character", method = RequestMethod.GET)
	public JSONArray retrieveCharacter(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getCharacter();
		
		return jsonArray;
	}
	
	@RequestMapping(value = "/retrieve/destination", method = RequestMethod.GET)
	public JSONArray retrieveDestination(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getDestination();
		
		return jsonArray;
	}
	
	@RequestMapping(value = "/retrieve/grade", method = RequestMethod.GET)
	public JSONArray retrieveGrade(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getGrade();
		
		return jsonArray;
	}
	
	@RequestMapping(value = "/retrieve/itability", method = RequestMethod.GET)
	public JSONArray retrieveItability(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getItability();
		
		return jsonArray;
	}
	
	@RequestMapping(value = "/retrieve/career", method = RequestMethod.GET)
	public JSONArray retrieveCareer(Locale locale, Model model) {
		JSONArray jsonArray = new JSONArray();
		
		jsonArray = retrieveService.getCareer();
		
		return jsonArray;
	}
	
	
	
	
}
