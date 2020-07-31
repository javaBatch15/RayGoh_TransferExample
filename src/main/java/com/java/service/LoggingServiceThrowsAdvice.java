package com.java.service;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LoggingServiceThrowsAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		System.out.println("Logging service throws advice called for " + method.getName() + " with exception "
				+ ex.getStackTrace());
	}

}
