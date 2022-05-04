package com.FrameWork.Bootcamp_ApiAutomation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Put_Operation {

	@Test
	public void update_record_in_Customers() {
		
		System.out.println("====================== PUT REQUEST =========================");
		System.out.println("Update a record in Customers");
		
		HashMap data = new HashMap();
		data.put("name", "Muhammad Afridi");
		data.put("city", "LongIsland City");
		
		Response resp = 
				given().
				contentType("application/json").
				contentType(ContentType.JSON).
				body(data).

				when().
				put("http://localhost:3000/Customers/184").
				then ().
				statusCode(200).
				log().all().
				extract().response();
		String JsonString = resp.asPrettyString();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Record Updated successfully" +data.toString());  
	}
	@Test
	public void Update_record_in_Employee_Details() {
		
		System.out.println("====================== PUT REQUEST =========================");
		System.out.println("Update a record in EmployeeDetails");
		
		HashMap data = new HashMap();
		data.put("Email", "r.afridy@gmail.com");
		data.put("FirstName", "Muhammad");
		data.put("LastName", "Afridi");
		data.put("JobTitle", "vice-President");
		
		
		Response resp = 
				given().
				contentType("application/json").
				contentType(ContentType.JSON).
				body(data).

				when().
				put("http://localhost:3000/EmployeeDetails/1060").
				then ().
				statusCode(200).
				log().all().
				extract().response();
		String JsonString = resp.asPrettyString();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Record Updated successfully" +data.toString());
		
	}
	@Test
	public void update_record_in_City () {
		
		System.out.println("====================== PUT REQUEST =========================");
		System.out.println("Update a record in City");
		
		HashMap data = new HashMap();
		data.put("city", "Las Vegas");
		
		
		
		Response resp = 
				given().
				contentType("application/json").
				contentType(ContentType.JSON).
				body(data).

				when().
				put("http://localhost:3000/City/106").
				then ().
				statusCode(200).
				log().all().
				extract().response();
		String JsonString = resp.asPrettyString();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Record Updated successfully" +data.toString());
	}
}
