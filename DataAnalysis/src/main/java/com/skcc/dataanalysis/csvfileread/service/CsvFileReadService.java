package com.skcc.dataanalysis.csvfileread.service;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.stereotype.Service;

import com.skcc.dataanalysis.common.vo.PersonVO;
import com.skcc.dataanalysis.csvfileread.vo.CsvFileVO;


@Service("csvFileReadService")
public class CsvFileReadService {

	public void readCsvFile(CsvFileVO csvFileVO) {
		try{
			Reader reader = Files.newBufferedReader(Paths.get(csvFileVO.getCsvFilePath()));
			ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(PersonVO.class);
            String[] memberFieldsToBindTo = 
            {"id", "gender", "age", "university", "major", "submajor", "grade", "area", "itability", "career", "isintern"
            	 ,"achieve", "idea", "professionalism", "teamwork"};
            strategy.setColumnMapping(memberFieldsToBindTo);
			
            CsvToBean csvToBean = 
            		new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            
            List<PersonVO> personVoList = csvToBean.parse();

            for (PersonVO person : personVoList) {
            	System.out.println("id : "			+	person.getId());
            	System.out.println("gender : "		+	person.getGender());
            	System.out.println("age : "			+	person.getAge());
            	System.out.println("university : "	+	person.getUniversity());
            	System.out.println("major : "		+	person.getMajor());
            	System.out.println("grade : "		+	person.getGrade());
            	System.out.println("area : "		+	person.getArea());
            	System.out.println("itability : "	+	person.getItability());
            	System.out.println("career : "		+	person.getCareer());
            	System.out.println("isintern : "	+	person.getIsintern());
            	
            	System.out.println("achieve : "			+	person.getAchieve());
            	System.out.println("idea : "			+	person.getIdea());
                System.out.println("professionalism : "	+	person.getProfessionalism());
                System.out.println("teamwork : "		+	person.getTeamwork());
                System.out.println("---------------------------");
            }
            
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public void readCsvFileByReader(BufferedReader reader, String fileName) {
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(PersonVO.class);
        String[] memberFieldsToBindTo = 
        {"id", "gender", "age", "university", "major", "submajor", "grade", "area", "itability", "career", "isintern"
        	 ,"achieve", "idea", "professionalism", "teamwork"};strategy.setColumnMapping(memberFieldsToBindTo);
        
        CsvToBean csvToBean = 
        		new CsvToBeanBuilder(reader)
                .withMappingStrategy(strategy)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        
        List<PersonVO> personVoList = csvToBean.parse();

        /*
        for (PersonVO person : personVoList) {
        	System.out.println("id : "			+	person.getId());
        	System.out.println("gender : "		+	person.getGender());
        	System.out.println("age : "			+	person.getAge());
        	System.out.println("university : "	+	person.getUniversity());
        	System.out.println("major : "		+	person.getMajor());
        	System.out.println("grade : "		+	person.getGrade());
        	System.out.println("area : "		+	person.getArea());
        	System.out.println("itability : "	+	person.getItability());
        	System.out.println("career : "		+	person.getCareer());
        	System.out.println("isintern : "	+	person.getIsintern());
        	
        	System.out.println("achieve : "			+	person.getAchieve());
        	System.out.println("idea : "			+	person.getIdea());
            System.out.println("professionalism : "	+	person.getProfessionalism());
            System.out.println("teamwork : "		+	person.getTeamwork());
            System.out.println("---------------------------");
        }
		*/
        
        for(PersonVO abc : personVoList) {
        	
        	
        }

        
        
        
	}

}
