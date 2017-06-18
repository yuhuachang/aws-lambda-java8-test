package com.morrisonexpress.lambda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import org.junit.Test;

public class HelloPojoTest {

    private static Context context;

    @BeforeClass
    public static void beforeClass() {

        // mock logger
        LambdaLogger logger = mock(LambdaLogger.class);

        // mock context
        context = mock(Context.class);
        when(context.getLogger()).thenReturn(logger);
    }
    
    @Test
	public void test() {
		
		RequestClass req = new RequestClass("John", "Smith");
		
		HelloPojo pojo = new HelloPojo();

		ResponseClass res = pojo.handleRequest(req, context);

		assertEquals("Hello John, Smith.", res.getGreetings());
	}

}
