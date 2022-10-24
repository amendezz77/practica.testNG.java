package org.quality.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class PracticaRestAssured {
	
	@Test
    public void verifyUser() {
 
        // Given
        given()
         
        // When
        .when()
              .get("http://dummy.restapiexample.com/api/v1/employee/2")
                 
         // Then
         .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify booking id at index 3
                .body("data.employee_name", equalTo("Garrett Winters"))
                .body("message", equalTo("Successfully! Record has been fetched."));
    }
	
	@Test
    public void createUser() {
 
        JSONObject data = new JSONObject();
 
        data.put("employee_name", "APITest");
        data.put("employee_salary", "99999");
        data.put("employee_age", "30");
 
         
        // GIVEN
        given()
               .baseUri("http://dummy.restapiexample.com/api")
               .contentType(ContentType.JSON)
               .body(data.toString())
 
        // WHEN
        .when()
               .post("/v1/create")
 
        // THEN
        .then()
               .statusCode(200)
               .body("data.employee_name", equalTo("APITest"))
               .body("message", equalTo("Successfully! Record has been added."));
 
    }
 
}
