package Requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {

	//@Test (priority = 1)
	void TestCookies() {
		
		given()
	
		.when()
		      .get("https://www.google.com/")
	    .then()
		      .log().all();
		
	}
	
	//@Test (priority = 2)
	void getCookieInfo() {
		
		Response res = given()
		
		.when().get("https://www.google.com/");
		
		//get single cookie info
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of cookie --------->"+ cookie_value);
		
		
	}
	
	@Test (priority = 2)
	void getAllCookiesInfo() { 
		
		Response res = given()
				
				.when().get("https://www.google.com/");
		Map<String, String> cookies_values = res.getCookies();
		
		//read all the keys and all values of cookies
		
		
		for(String k:cookies_values.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"    "+cookie_value);

		}
		

	}
	
}
