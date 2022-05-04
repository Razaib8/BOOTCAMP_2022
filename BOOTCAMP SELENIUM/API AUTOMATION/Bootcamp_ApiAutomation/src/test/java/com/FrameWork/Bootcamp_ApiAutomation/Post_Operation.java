package com.FrameWork.Bootcamp_ApiAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post_Operation {

	@Test
	public void Add_a_record_in_EmployeeDetails() {
		
		System.out.println("====================== POST REQUEST =========================");
		System.out.println("Add a record in EmployeeDetails");
		
		HashMap data = new HashMap();
		data.put("FirstName", "Muhammad");
		data.put("LastName", "Afridi");
		data.put("Email", "r.afridy@gmail.com");
		data.put("JobTitle", "Vice President");
		
		Response resp = 
				given().
				contentType("application/json").
				contentType(ContentType.JSON).
				body(data).

				when().
				post("http://localhost:3000/EmployeeDetails").
				then ().
				statusCode(201).
				log().all().
				extract().response();
		String JsonString = resp.asPrettyString();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println("Record Inserted successfully" +data.toString());
	}
	@Test
	public void add_a_record_in_Customers () {
		
		System.out.println("====================== POST REQUEST =========================");
		System.out.println("Add a record in Customers");
		
		HashMap data = new HashMap();
		data.put("name", "Arif Hanif");
		data.put("city", "RegoPark");
		
		Response resp = 
				given().
				contentType("application/json").
				contentType(ContentType.JSON).
				body(data).

				when().
				post("http://localhost:3000/Customers").
				then ().
				statusCode(201).
				log().all().
				extract().response();
		String JsonString = resp.asPrettyString();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println("Record Inserted successfully" +data.toString());
	}
	@Test
	public void add_a_record_in_city () {
		
		System.out.println("====================== POST REQUEST =========================");
		System.out.println("Add a record in City");
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Sadek Abbout");
		data.put("city", "Brooklyn NY");
		
		Response resp = 
				given().
				contentType("application/json").
				contentType(ContentType.JSON).
				body(data).

				when().
				post("http://localhost:3000/City").
				then ().
				statusCode(201).
				log().all().
				extract().response();
		String JsonString = resp.asPrettyString();
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		System.out.println("Record Inserted successfully" +data.toString());
	}
}
