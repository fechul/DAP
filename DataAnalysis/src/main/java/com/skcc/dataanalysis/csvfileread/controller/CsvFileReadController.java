package com.skcc.dataanalysis.csvfileread.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skcc.dataanalysis.csvfileread.service.CsvFileReadService;
import com.skcc.dataanalysis.csvfileread.vo.CsvFileVO;

@Controller
public class CsvFileReadController {

	@Autowired
	private CsvFileReadService csvFileReadService;
	
	private static final Logger logger = LoggerFactory.getLogger(CsvFileReadController.class);

	//@RequestMapping(value = "/csvFileRead", method = RequestMethod.POST)
	//public String csvFileRead(Locale locale, Model model, CsvFileVO csvFileVO){
	@RequestMapping(value = "/csvFileRead", method = RequestMethod.GET)
	public String csvFileRead(Locale locale, Model model){	
		CsvFileVO csvFileVO = new CsvFileVO();
		
		csvFileVO.setCsvFileName("data.csv");
		csvFileVO.setCsvFilePath("D:\\data.csv");
		
		csvFileReadService.readCsvFile(csvFileVO);
		
		return "home";
	}
	
}
