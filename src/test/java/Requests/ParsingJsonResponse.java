package Requests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponse {
// parsing json response body
	
	//@Test 
	void TestJsonResponse() {
		
		//Aproach1 VALIDATING JSON RESPONSE USING MATCHERS
		
		given()
		       .contentType("ContentType.JSON")
		
		.when()
		       .get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("data.last_name", equalTo("Weaver"));
		
				
		
		
	}
	
	//Aproach2 VALIDATING JSON RESPONSE USING ASSERTIONS (Without using `Then()`)
	@Test 
	void TestingJsonResponse() {
		Response res = given()
	       .contentType("ContentType.JSON")
	
	.when()
	       .get("https://reqres.in/api/users/2");
	       
	       Assert.assertEquals(res.getStatusCode(), 200);
	       Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	   String data =    res.jsonPath().get("data.last_name").toString();  //used toString otherwise key value will be returned in object form. 
	     //now after getting the string value, we storing it into the data variable
	     
	   //now we using Assert equals to validate the response 
	   Assert.assertEquals(data, "Weaver");
	       
	}
	
	
	
}
