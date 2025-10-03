package Requests;
import org.testng.annotations.Test;

import java.io.FileReader;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class OrgJson {

	
	/* 
	Post Request using ORG Json
	*/
	
	//@Test (priority = 1)
	void testPostUsingOrgJsonLibrary() { //post request using ORG Json
		
		JSONObject data = new JSONObject();
		data.put("name", "Azka");
		data.put("job", "QA Analyst");
		
		given()
              .contentType("application/json")
              .body(data.toString())

        .when()
               .post("https://reqres.in/api/users")

        .then()
               .statusCode(201)
		       .body("name", equalTo("Azka"))
		       .body("job", equalTo("QA Analyst"))
		       .log().all();
		
}
	
	//@Test
	void testPostUsingPOJO() { //post request using POJO class (have to create separate class for POJO) 
		
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
	
	@Test
	void testPostUsingExternalJsonFile()  throws FileNotFoundException {
		
		File f = new File(".\\BODY.JSON"); //file location 
		
		FileReader fr = new FileReader(f); //file reader class
		
		JSONTokener jt = new JSONTokener(fr); //breaks the file content into json tokens (parses raw text into json structure) 
		
		JSONObject data = new JSONObject(jt); //convert the parsed tokens into a json object 
		
		
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
		
		
		
	}
	
