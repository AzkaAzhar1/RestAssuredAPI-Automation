package Requests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Headers {
	
	void TestHeader() {
		
		given()
	    
		.when()
	           .get("https://www.google.com/")
	      
	      .then();
	}
	

}
