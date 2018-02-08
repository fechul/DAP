package com.skcc.dataanalysis.woolim.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.skcc.dataanalysis.woolim.vo.WoolimVO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service("woolimService")
public class WoolimService {

	public void woolimTest(WoolimVO woolimVO){
		
		String aibrilText = woolimVO.getAibrilText();
		System.out.println("INPUT TEXT : " + aibrilText);

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
				Map<String, Object> map = new HashMap<String, Object>();
				  
				try {
					for (int j = 0; j < abrilResponse.size(); j++)
					{
						String json = mapper.writeValueAsString(abrilResponse.get(j));
						Object obj = parser.parse(json);
						jObject = (JSONObject) obj;
						
						String text = (String) jObject.get("text");					   
					    Double relevance = (Double)jObject.get("relevance");
					    
						map.put(text,relevance.toString());
				    }
				} catch (Exception ex) {
				}
				System.out.println(map);

	}
}
