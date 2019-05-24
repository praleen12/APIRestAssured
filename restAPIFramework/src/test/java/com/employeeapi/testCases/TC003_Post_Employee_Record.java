package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC003_Post_Employee_Record extends TestBase {

	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSalary();
	String empAge = RestUtils.empAge();
	Response response;

	@BeforeClass
	void createEmployee() throws InterruptedException {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		System.out.println();

		JSONObject requestParameters = new JSONObject();
		requestParameters.put("name", empName);
		requestParameters.put("salary", empSalary);
		requestParameters.put("age", empAge);

		// Add header stating the request body is JSON
		httpRequest.header("Content-Type", "application/json");

		// Add json to the body of the request
		httpRequest.body(requestParameters.toJSONString());

		// Post the request and check the response
		response = httpRequest.post("/create");
		System.out.println(response);
		Thread.sleep(5000);
	}

	@Test
	void checkResponseBody() {

		String responsebody = response.getBody().asString();

		Assert.assertEquals(responsebody.contains(empName), true);
		Assert.assertEquals(responsebody.contains(empSalary), true);
		Assert.assertEquals(responsebody.contains(empAge), true);
	}
	
	@AfterClass
	void tearDown() {
		
	}

}
