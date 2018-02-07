package com.skcc.dataanalysis.csvfileread.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.opencsv.CSVReader;
import com.skcc.dataanalysis.csvfileread.service.CsvFileReadService;
import com.skcc.dataanalysis.csvfileread.vo.CsvFileVO;

@Controller
public class CsvFileReadController {

	@Autowired
	private CsvFileReadService csvFileReadService;
	
    @Resource(name="uploadPath")
    String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(CsvFileReadController.class);
	
	
	@RequestMapping(value = "/csvFileSubmit.do", method = RequestMethod.POST)
	public String csvFileRead(MultipartHttpServletRequest request) throws IOException{
		
		MultipartFile file = request.getFile("fileSelect");		
		String fileName = file.getOriginalFilename();
		BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
		
		csvFileReadService.readCsvFileByReader(reader, fileName);
		
		return "home";
	}
	
	@RequestMapping(value = "/csvFileRead", method = RequestMethod.GET)
	public String csvfileTestRead(Locale locale, Model model){	
		
		CsvFileVO csvTempFileVO = new CsvFileVO();
		csvTempFileVO.setCsvFileName("data.csv");
		csvTempFileVO.setCsvFilePath("D:\\data.csv");
		csvFileReadService.readCsvFile(csvTempFileVO);
		
		return "home";
	}
	
}
