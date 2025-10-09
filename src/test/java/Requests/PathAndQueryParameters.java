package Requests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class PathAndQueryParameters {

	
	@Test 
	void TestQueryAndPathParameteres() {
		
		//https://reqres.in/api/users?page=2
		
		given()
		      .pathParam("mypath", "users")
		      .queryParam("page", 2)
		      
		.when()
		      .get("https://reqres.in/api/{mypath}")
		      
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
}
