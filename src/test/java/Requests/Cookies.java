package Requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Cookies {

	@Test
	void TestCookies() {
		
		given()
	
		.when()
		      .get("https://www.google.com/")
	    .then()
		      .log().all();
		
	}
}
