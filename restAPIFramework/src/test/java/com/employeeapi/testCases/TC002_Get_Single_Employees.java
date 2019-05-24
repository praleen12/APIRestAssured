package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_Get_Single_Employees extends TestBase {

	@BeforeClass
	void getAllEmployees() throws InterruptedException {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		System.out.println(empID);
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/" + empID);
		Thread.sleep(3000);
		System.out.println(response);

	}

	@Test
	void checkResponseBoday() {
		
		String responseBody = response.getBody().toString();
		System.out.println("RESPONSE BODY: " + responseBody);

		Assert.assertTrue(responseBody != null);
//		Assert.assertEquals(responseBody.contains(empID), true);

	}

	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	void checkResponseTime() {
		long responseTime = response.getTime();
		Assert.assertTrue(responseTime<200);
		
	}
	
	@Test
	void checkStatusLine() {
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
				
		
	}
	
	@AfterClass
	void tearDown() {
		
	}

}
