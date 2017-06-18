package com.morrisonexpress.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/*
 * handler: com.morrisonexpress.lambda.HelloPojo::handleRequest
 * */
public class HelloPojo implements RequestHandler<RequestClass, ResponseClass> {

	public ResponseClass handleRequest(RequestClass request, Context context) {
        LambdaLogger logger = context.getLogger();

		String greetingString = String.format("Hello %s, %s.", request.getFirstName(), request.getLastName());

        logger.log("log data from LambdaLogger \n this is continuation of logger.log");
        logger.log("greeting: " + greetingString);
        logger.log(String.format("log stream = %s", context.getLogStreamName()));

		return new ResponseClass(greetingString);
	}
}