package com.morrisonexpress.lambda;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloPojoTest {

	@Test
	public void test() {
		
		RequestClass req = new RequestClass("John", "Smith");
		
		HelloPojo pojo = new HelloPojo();
		
		//TODO: mock aws context...
		ResponseClass res = pojo.handleRequest(req, null);

		assertEquals("Hello John, Smith.", res.getGreetings());
	}

}
