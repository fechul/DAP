package com.skcc.dataanalysis.csvfileread.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryRelations.Sort;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
        {"id", "gender", "age", "university", "major", "submajor", "grade", "area", "career", "category", "itability",
         "isintern" ,"achieve", "idea", "professionalism", "teamwork"};strategy.setColumnMapping(memberFieldsToBindTo);
        
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
        
        for(PersonVO person : personVoList){
        	person.getId();			// int 		id
        	person.getGender();		// String	gender
        	person.getAge();		// String	age;
        	person.getUniversity();	// String	university;
        	person.getMajor();		// String 	major;
        	person.getSubmajor();	// String	submajor;
        	person.getGrade();		// String	grade;
        	person.getArea();		// String	area;
        	person.getCareer();		// String	career;
        	person.getCategory();	// String	category;
        	person.getIsintern();	// String	isintern;
        }
        
        Map<String, Integer> itAbilityMap = new HashedMap();
        
        for(PersonVO person : personVoList){
        	List<String> itabilityList =Arrays.asList(person.getItability().split(","));
        	for(String itabilityValue : itabilityList) {
        		if(itAbilityMap.get(itabilityValue) == null) {
        			itAbilityMap.put(itabilityValue, 1);
        		}
        		else {
        			int count = itAbilityMap.get(itabilityValue);
        			count++;
        			itAbilityMap.put(itabilityValue, count);
        		}
        	}
        }
        
        // 1번문항 처리
        Map<String, Double> achieveJsonWeight = new LinkedHashMap<String, Double>();
        for(PersonVO person : personVoList){
        	String aibrilText = person.getAchieve();
        	System.out.println("Person Id" + person.getId());
        	Map<String, Double> aibrilJSON = this.getAibrilJSON(aibrilText);
        	
        	for(String keyword : aibrilJSON.keySet()) {
        		if(achieveJsonWeight.get(keyword) == null) {
        			achieveJsonWeight.put(keyword, aibrilJSON.get(keyword));
        		}
        		else{
        			Double newRelevanceValue = achieveJsonWeight.get(keyword) + aibrilJSON.get(keyword);
        			achieveJsonWeight.put(keyword, newRelevanceValue);
        		}
        	}
        }
        
        // 2번문항 처리
        Map<String, Double> ideaJsonWeight = new LinkedHashMap<String, Double>();
        for(PersonVO person : personVoList){
        	String aibrilText = person.getIdea();
        	Map<String, Double> aibrilJSON = this.getAibrilJSON(aibrilText);
        	
        	for(String keyword : aibrilJSON.keySet()) {
        		if(ideaJsonWeight.get(keyword) == null) {
        			ideaJsonWeight.put(keyword, aibrilJSON.get(keyword));
        		}
        		else{
        			Double newRelevanceValue = ideaJsonWeight.get(keyword) + aibrilJSON.get(keyword);
        			ideaJsonWeight.put(keyword, newRelevanceValue);
        		}
        	}
        }
        
        
        // 3번문항 처리
        Map<String, Double> professionalismJsonWeight = new LinkedHashMap<String, Double>();
        for(PersonVO person : personVoList){
        	String aibrilText = person.getIdea();
        	Map<String, Double> aibrilJSON = this.getAibrilJSON(aibrilText);
        	
        	for(String keyword : aibrilJSON.keySet()) {
        		if(professionalismJsonWeight.get(keyword) == null) {
        			professionalismJsonWeight.put(keyword, aibrilJSON.get(keyword));
        		}
        		else{
        			Double newRelevanceValue = professionalismJsonWeight.get(keyword) + aibrilJSON.get(keyword);
        			professionalismJsonWeight.put(keyword, newRelevanceValue);
        		}
        	}
        }
        
        // 4번문항 처리
        Map<String, Double> teamworkJsonWeight = new LinkedHashMap<String, Double>();
        for(PersonVO person : personVoList){
        	String aibrilText = person.getIdea();
        	Map<String, Double> aibrilJSON = this.getAibrilJSON(aibrilText);
        	
        	for(String keyword : aibrilJSON.keySet()) {
        		if(teamworkJsonWeight.get(keyword) == null) {
        			teamworkJsonWeight.put(keyword, aibrilJSON.get(keyword));
        		}
        		else{
        			Double newRelevanceValue = teamworkJsonWeight.get(keyword) + aibrilJSON.get(keyword);
        			teamworkJsonWeight.put(keyword, newRelevanceValue);
        		}
        	}
        }
        
        
        
        System.out.println("성공");
        System.out.println(achieveJsonWeight);
        
        
        
	}

	public Map<String, Double> getAibrilJSON(String aibrilText){
		NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
				  NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
				  "b8836edc-9be8-4f18-b417-d3ba3d78d773",
				  "MP7JzwuCCUf0"
				);

				KeywordsOptions keywords= new KeywordsOptions.Builder()
				  .sentiment(true)
				  .emotion(true)
				  .build();

				Features features = new Features.Builder()
				  .keywords(keywords)
				  .build();

				AnalyzeOptions parameters = new AnalyzeOptions.Builder()
				  .text(aibrilText)
				  .features(features)
				  .build();

				AnalysisResults response = service
				  .analyze(parameters)
				  .execute();
				
				List<KeywordsResult> abrilResponse = response.getKeywords();
			
				JSONObject jObject = new JSONObject();
				ObjectMapper mapper = new ObjectMapper();
				JSONParser parser = new JSONParser();
				Map<String, Double> map = new HashMap<String, Double>();
				  
				try {
					for (int j = 0; j < abrilResponse.size(); j++)
					{
						String json = mapper.writeValueAsString(abrilResponse.get(j));
						Object obj = parser.parse(json);
						jObject = (JSONObject) obj;
						
						String text = (String)jObject.get("text");					   
					    Double relevance = (Double)jObject.get("relevance");
					    
						map.put(text,relevance);
				    }
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				return map;
	}

	
}
