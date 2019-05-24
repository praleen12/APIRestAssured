package com.employeeapi.base;

import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "9066";

	@BeforeClass
	public void setup() {

	}

}
