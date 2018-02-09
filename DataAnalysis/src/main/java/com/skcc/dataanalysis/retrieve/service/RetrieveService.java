package com.skcc.dataanalysis.retrieve.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;;

@Service("retrieveService")
public class RetrieveService {

	
/*
  var genderData = [
					  	{
					       "label": "남자",
					       "value": 37
					    }, 
					    {
					       "label": "여자",
					       "value": 22
					    }
    				];
*/
public List<Map<String, Object>> getGender() throws Exception {
	  List<Map<String, Object>> jsonObjectList = new ArrayList<Map<String, Object>>();
      
	  Map<String, Object> jsonObject = new HashMap<String, Object>();
      
      
      URL url = new URL("http://169.56.124.28:7070/api/v1/util/jdbc/query/execute?type=hive&url=jdbc%3Ahive2%3A%2F%2Fdataplatform15.skcc.com%3A10000&database=itproject&user=hive&password=hive&query=SELECT+gender+as+label%2C+count(gender)+as+value+from+person+group+by+gender");

      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      conn.setDoOutput(true);
      
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
      }
      in.close();
      String jsonStr = response.toString();
      
      JSONParser parser = new JSONParser();
      Object obj = parser.parse(jsonStr);
      JSONObject jsonObj = (JSONObject) obj;
      
      JSONObject 	data = 	(JSONObject)jsonObj.get("data");
      JSONArray 	rows = 	(JSONArray)data.get("rows");
      System.out.println("rows");
      System.out.println(rows);

      return rows;
   }



	public JSONArray getAge() {
		JSONArray jsonArray = new JSONArray();
		
		/*
				var ageData = [{
			"label": "23",
			"value": 2
		},{
			"label": "24",
			"value": 4
		},{
			"label": "25",
			"value": 9
		},{
			"label": "26",
			"value": 8
		},{
			"label": "27",
			"value": 17
		},{
			"label": "28",
			"value": 13
		},{
			"label": "29",
			"value": 3
		},{
			"label": "30",
			"value": 2
		},{
			"label": "31",
			"value": 1
		}];
		*/
		
		return jsonArray;
	}

	public JSONArray getMajor() {
		JSONArray jsonArray = new JSONArray();
		
		/*
		var majorInfo = [{'name': '컴퓨터과학','size': 13},
		{'name': '소프트웨어학과','size': 11},
		{'name': '경영학과','size': 7},
		{'name': 'IT공학과','size': 19},
		{'name': '경제학과','size': 3},
		{'name': '전기전자컴퓨터공학부','size': 5},
		{'name': '국어국문학과','size': 2},
		{'name': '산업공학과','size': 8}];
		*/
		
		return jsonArray;
	}

	public JSONArray getCharacter() {
		JSONArray jsonArray = new JSONArray();
		
		/*
		var data = [{"category": '1',"password": '패기'}, 
        {"category": '2',"password": '열정'},
        {"category": '3',"password": '친화력'}, 
        {"category": '4',"password": '짜증'}, 
        {"category": '5',"password": '밝음'}];
		*/
		
		return jsonArray;
	}

	public JSONArray getDestination() {
		JSONArray jsonArray = new JSONArray();
		
		/*
		destinations: [
 {'coord': [127.104456, 37.513931], 'name': '고성군'},
 {'coord': [23.9569, 49.8134], 'name': 'LWO'},
 {'coord': [0.065603, 40.207479], 'name': 'CDT'},
 {'coord': [-3.56795, 40.4839361], 'name': 'MAD'},
 {'coord': [2.071062, 41.288288], 'name': 'BCN'},
 {'coord': [2.766066, 41.898201], 'name': 'GRO'},
 {'coord': [14.483279, 35.854114], 'name': 'MLA'},     
 {'coord': [23.9484, 37.9356467], 'name': 'ATH'},   
 {'coord': [19.914486, 39.607645], 'name': 'CFU'},
 {'coord': [34.9362, 29.9511], 'name': 'VDA'},
 {'coord': [129.163984, 35.165740], 'name': '밀양시'}
]
		*/
		
		return jsonArray;
	}

	public JSONArray getGrade() {
		JSONArray jsonArray = new JSONArray();
		
		/*
GradeData = {
 "avgGrade": 3.2,
 "gradeA": 13,
 "gradeB": 3,
 "gradeC": 3
};
		*/
		
		return jsonArray;
	}

	public JSONArray getItability() {
		JSONArray jsonArray = new JSONArray();
		
		/*
d = [
 [
  {axis:"Java", value:10},
  {axis:"Python", value:20},
  {axis:"C", value:30},
  {axis:"Javascript", value:40},
  {axis:"C++", value:20},
  {axis:"Go", value:10}
 ]
];

		*/
		
		return jsonArray;
	}

	public JSONArray getCareer() {
		JSONArray jsonArray = new JSONArray();
		
		/*
careerData = {
 "nodes": [
  { "name": "빅데이터", "group": 1, "value": 2 },
  { "name": "처리", "group": 2, "value": 20 },
  { "name": "분석", "group": 2, "value": 5 },
  { "name": "데이터", "group": 2, "value": 10},
  { "name": "AI", "group": 3, "value": 8 },
  { "name": "IoT", "group": 3, "value": 2 },
  { "name": "엔지니어", "group": 2, "value": 3 },
  { "name": "제조", "group": 4, "value": 5 },
  { "name": "인프라", "group": 4, "value": 9 },
  { "name": "IoT 전문가", "group": 4, "value": 33 }
 ],
 "links": [
  { "source": 0, "target": 1, "value": 1 },
  { "source": 0, "target": 2, "value": 1 },
  { "source": 0, "target": 3, "value": 1 },
  { "source": 0, "target": 6, "value": 1 },
  { "source": 4, "target": 5, "value": 2 },
  { "source": 4, "target": 0, "value": 3 },
  { "source": 5, "target": 0, "value": 3 },
  { "source": 5, "target": 7, "value": 4 },
  { "source": 5, "target": 8, "value": 4 },
  { "source": 5, "target": 9, "value": 4 },
  { "source": 8, "target": 9, "value": 2 }
 ]
}
		*/
		
		return jsonArray;
	}



}
