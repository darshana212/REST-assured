package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchAndDeleteExamples {
	
	@Test
	public void tesPut() {
	
	JSONObject request = new JSONObject();
	
	request.put("title", "Darshana");
	request.put("body", "Automation Test Engineer");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://jsonplaceholder.typicode.com/";
	
	given().relaxedHTTPSValidation().
		header("Content-Type", "application/json").
		header("x-api-key", "reqres-free-v1").  // IMPORTANT
		body(request.toJSONString()).
	when().
		put("/posts/1").
	then().
		statusCode(200).log().all();


	
}
	
	@Test
	public void tesPatch() {
	
	JSONObject request = new JSONObject();
	
	request.put("title", "Darshana");
	request.put("body", "Automation Test Engineer");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://jsonplaceholder.typicode.com/";
	
	given().relaxedHTTPSValidation().
		header("Content-Type", "application/json").
		header("x-api-key", "reqres-free-v1").  // IMPORTANT
		body(request.toJSONString()).
	when().
		patch("/posts/1").
	then().
		statusCode(200).log().all();


	
}
	
	@Test
	public void testDelete() {
	
	
	
	baseURI = "https://jsonplaceholder.typicode.com/";
	
	when().
		delete("/posts/1").
	then().
		statusCode(200).log().all();


	
}
	
	

}
