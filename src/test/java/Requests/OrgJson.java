package Requests;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class OrgJson {

	
	/* 
	Post Request using ORG Json
	*/
	
	//@Test (priority = 1)
	void testPostUsingOrgJsonLibrary() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Azka");
		data.put("job", "QA Engineer");
		
		given()
              .contentType("application/json")
              .body(data.toString())

        .when()
               .post("https://reqres.in/api/users")

        .then()
               .statusCode(201)
		       .body("name", equalTo("Azka"))
		       .body("job", equalTo("QA Engineer"))
		       .log().all();
		
}
	
	@Test
	void testPostUsingPOJO() {
		
		POJOclass data = new POJOclass();
		data.setName("azka");
		data.setJob("QA Engineer");
		
		given()
        .contentType("application/json")
        .body(data)

  .when()
         .post("https://reqres.in/api/users")

  .then()
         .statusCode(201)
	       .body("name", equalTo("Azka"))
	       .body("job", equalTo("QA Engineer"))
	       .log().all();
	
		
	}
		
		
		
	}
	
