package com.FrameWork.Bootcamp_ApiAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Delete_Operation {
	@Test
	public void Delete_a_record_from_Customers() {
	System.out.println("====================== DELETE REQUEST =========================");
	System.out.println(" Delete a record from the Customers Table ");
	
	Response resp =
			given().
			when().
			delete("http://localhost:3000/Customers/185").
			then().
			statusCode(200).
			log().all().
			extract().response();
	
	int codes = resp.getStatusCode();
	Assert.assertEquals(codes, 200, "Status code is different");
			
	}  

	@Test
    public void Delete_a_record_from_EmployeeDetails() {
	System.out.println("====================== DELETE REQUEST =========================");
	System.out.println(" Delete a record from EmployeeDetails Table ");
	
	Response resp =
			given().
			when().
			delete("http://localhost:3000/EmployeeDetails/203").
			then().
			statusCode(200).
			log().all().
			extract().response();
	
	int codes = resp.getStatusCode();
	Assert.assertEquals(codes, 200, "Status code is different");
			
	}  

    @Test
	public void Delete_a_record_from_City() {
	System.out.println("====================== DELETE REQUEST =========================");
	System.out.println(" Delete a record from the City Table ");
	
	Response resp =
			given().
			when().
			delete("http://localhost:3000/City/112").
			then().
			statusCode(200).
			log().all().
			extract().response();
	
	int codes = resp.getStatusCode();
	Assert.assertEquals(codes, 200, "Status code is different");
			
	}  
}