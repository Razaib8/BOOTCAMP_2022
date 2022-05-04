package com.FrameWork.Bootcamp_ApiAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*
 Possible operation for EmployeeDetails using GET method
 Scenario_01:get all EmployeeDetails
 Scenario_02:search Employee by job title
 Scenario_03:search Employee by last Name
 Scenario_04search customers by city
 Scenario_05get all city
 
 given, when, then, and, but ===== REST BDD
 Given, When, Then, And, But ===== BDD
 
 */
public class Get_Operation {

	@Test
	public void get_all_data_from_EmployeeDetails() {
		System.out.println("====================== GET REQUEST =========================");
		System.out.println(" Get all data from the EmployeeDetails table.");
		
		Response resp =
				given().
				contentType("application/json").
				accept(ContentType.JSON).
				when().
				get("http://localhost:3000/EmployeeDetails").
				then().
				statusCode(200).
				log().all().
				extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is "+statusCode+" and Test is Passed!!");
		System.out.println("=============================================================");
		
	}
	
	@Test
	public void get_all_data_from_Customers() {
		System.out.println("====================== GET REQUEST =========================");
		System.out.println(" Get all data from the Customers table.");
		
		Response resp =
				given().
				contentType("application/json").
				accept(ContentType.JSON).
				when().
				get("http://localhost:3000/Customers").
				then().
				statusCode(200).
				log().all().
				extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is "+statusCode+" and Test is Passed!!");
		System.out.println("=============================================================");
	}
	@Test
	public void get_all_data_from_City() {
		System.out.println("====================== GET REQUEST =========================");
		System.out.println(" Get all data from the City table.");
		
		Response resp =
				given().
				contentType("application/json").
				accept(ContentType.JSON).
				when().
				get("http://localhost:3000/City").
				then().
				statusCode(200).
				log().all().
				extract().response();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("Status Code is "+statusCode+" and Test is Passed!!");
		System.out.println("=============================================================");
		
	}
}
