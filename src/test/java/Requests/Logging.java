package Requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Logging {

	@Test 
	void Testlogs() {
given()
	    
		.when()
	           .get("https://www.google.com/")
	      
	      .then()
	             .log().cookies()
	             .log().headers();
	}
}
