package Requests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*; 

/* given() content type, set cookies, add auth, add pram, set headers info etc

when() get, put, post, patch, delete

then() validate status code, extract response, extract header cookies, & response body
*/


public class HTTPRequests {

	@Test 
	void getusers() {
		
		given()
		
		.when()
		       .get("https://reqres.in/api/users?page=2")
		
		.then()
		       .statusCode(200)
		         .body("page", equalTo(2))
		         .log().all();
	}
}
