package Requests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ParsingJsonResponse {
// parsing json response body
	
	@Test 
	void TestJsonResponse() {
		
		//Aproach1
		
		given()
		       .contentType("ContentType.JSON")
		
		.when()
		       .get("https://reqres.in/api/users/2")
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		.body("data.last_name", equalTo("Weaver"));
		
				
		
		
	}
}
