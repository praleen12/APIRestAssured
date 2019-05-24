package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC005_Delete_Employee_Record extends TestBase {

	Response response;

	@BeforeClass
	void deteEmployee() throws InterruptedException {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET, "/employees");

		JsonPath jsonPathEvaluator = response.jsonPath();

		String empID = jsonPathEvaluator.getString("[0].id");
		response = httpRequest.request(Method.DELETE, "/delete/" + empID);
		Thread.sleep(4000);
	}

	@Test
	void checkResponseBody() {

		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);
		;

	}

}
