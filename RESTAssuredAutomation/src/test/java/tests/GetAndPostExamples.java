package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExamples {
	
	//@Test
	public void testGet() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		given().
			get("/posts").
		then().
			statusCode(200).
			body("$[5].title", equalTo("dolorem eum magni eos aperiam quia")).
			body("$.title", hasItems("dolorem eum magni eos aperiam quia","magnam facilis autem"));
	}
	
	@Test
	public void tesPost() {
		
		Map<String, Object> map= new HashMap<String, Object>();
		
//		map.put("name", "Darshana");
//		map.put("job", "Automation Tester");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("title", "Darshana");
		request.put("body", "Automation Tester");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		given().relaxedHTTPSValidation().
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/posts").
		then().
			statusCode(201).log().all();
		
		//System.out.println("Proxy Host: " + System.getProperty("https.proxyHost"));
		//System.out.println("Proxy Port: " + System.getProperty("https.proxyPort"));

		
	}
	
}
