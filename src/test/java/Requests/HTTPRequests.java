package Requests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map; 

/* given() content type, set cookies, add auth, add pram, set headers info etc

when() get, put, post, patch, delete

then() validate status code, extract response, extract header cookies, & response body
*/

public class HTTPRequests {
	
	String id;
	
	@Test (priority = 1)
	void getusers() {
		
		given()
		
		.when()
		       .get("https://reqres.in/api/users?page=2")
		
		.then()
		       .statusCode(200)
		         .body("page", equalTo(2))
		         .log().all();
	}
	
	@Test(priority = 2)
	void CreateUser() {
	    Map<String, String> hm = new HashMap<>();
	    hm.put("name", "azka");
	    hm.put("job", "QA Engineer");

	 id = given()
	             .contentType("application/json")
	             .body(hm)
		
		  .when()
		         .post("https://reqres.in/api/users")
		         .jsonPath().getString("id");
		
		
	}
	
   @Test(priority = 3, dependsOnMethods= {"CreateUser"})
	void UpdateUser() {
	    Map<String, String> hm = new HashMap<>();
	    hm.put("name", "azkaa");
	    hm.put("job", "QA Analyst");
	    
	    given()
	           .contentType("application/json")
	           .body(hm)
	           
	   .when()
              .put("https://reqres.in/api/users/" + id)   // use dynamic id
	  
	   .then()
	        .statusCode(200)
	       .log().all();
	} 
   
   @Test (priority = 4)
   void DeleteUser() {
	   
	   
	   given()
	  
	   .when()
	        .delete("https://reqres.in/api/users/"+ id)
	 
	   .then()
	         .statusCode(204)
	         .log().all();
	   
   } 
}
