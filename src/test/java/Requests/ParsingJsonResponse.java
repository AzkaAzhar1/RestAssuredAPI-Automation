package Requests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponse {
// parsing json response body
	
	//@Test 
	void TestJsonResponse() { //Not recommended approach 
		
		//Aproach1 VALIDATING JSON RESPONSE USING MATCHERS (but not recommended approach)
		
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
	
	
	//@Test 
	void TestingJsonResponse() { //Recommended Approach 
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
	
	
	//@Test 
	void TestJsonResponseBodyData() {  //Recommended Approach 
	
		Response res =	given()
	       .contentType("ContentType.JSON")
	
	.when()
	       .get("https://reqres.in/api/users?page=2");
		
		//To traverse entire Json response, using JSONObject class
		
		JSONObject Jo = new JSONObject(res.asString()); //converting response to Json object type
		
		for(int i = 0; i<Jo.getJSONArray("data").length();   i++) //we didn't know the length of the array thats we used getJSONArray
		{
			String emails = Jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(emails);
		}
		
	
	}
	
	
	@Test 
	void TestJsonResponseSingleBodyData() {
		Response res =	given()
			       .contentType("ContentType.JSON")
			
			.when()
			       .get("https://reqres.in/api/users?page=2");
				
				//To traverse entire Json response, using JSONObject class
				
				JSONObject Jo = new JSONObject(res.asString()); //converting response to Json object type
				
				boolean status = false;
				
				for(int i = 0; i<Jo.getJSONArray("data").length();   i++) //we didn't know the length of the array thats we used getJSONArray
				{
					String emails = Jo.getJSONArray("data").getJSONObject(i).get("email").toString();
					
				//target is to find that specific email in the response	
					if (emails.equals("michael.lawson@reqres.in"))
					{
						status = true;
						break;
					}
	}
				
				Assert.assertEquals(status, true);
	
	}
	}
