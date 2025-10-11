package Requests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersInfo {
	
	//@Test
	void TestHeader() {
		
		given()
	    
		.when()
	           .get("https://www.google.com/")
	      
	      .then()
	            .header("Content-Type", "text/html; charset=ISO-8859-1")
	            .and()
	            .header("Content-Encoding", "gzip")
	            .and()
	            .header("Server", "gws");
	            
	}
	//@Test
    void TestHeaders() {
		
		Response res = given()
	    
		.when()
	           .get("https://www.google.com/");
	      
		//get single header info
	         String headervalue =   res.getHeader("Content-Type");
	         System.out.println("Value of header is:"+ headervalue);
	         
	}
	
	@Test 
    void GetHeaders() {
		
		Response res = given()
	    
		.when()
	           .get("https://www.google.com/");
	      
	//capture all headers info
		Headers myheaders = res.getHeaders();
		
		for(Header hd:myheaders) 
		{
			System.out.println(hd.getName()+"  "+hd.getValue());
		}
		
		
	         
    }
}
