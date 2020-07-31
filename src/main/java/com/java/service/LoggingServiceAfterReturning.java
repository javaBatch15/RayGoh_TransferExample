package com.java.service;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LoggingServiceAfterReturning implements AfterReturningAdvice {
	Logger logger = Logger.getLogger(LoggingServiceAfterReturning.class);

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Logging service called for " + method.getName() + " after this " + returnValue.toString()
				+ " was returned.");

	}

}
