package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC004_Put_Employee extends TestBase {

	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSalary();
	String empAge = RestUtils.empAge();

	@BeforeClass
	void updateEmployee() throws InterruptedException {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		JSONObject requestParam = new JSONObject();
		requestParam.put("name", empName);
		requestParam.put("salary", empSalary);
		requestParam.put("age", empAge);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParam.toJSONString());
		response = httpRequest.request(Method.PUT, "/update/" + empID);
		Thread.sleep(5000);
		

	}

	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode()
;
		Assert.assertEquals(statusCode, 200);
		
	}
}
