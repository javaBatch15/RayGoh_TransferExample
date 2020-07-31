package com.java.service;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterAdvice;

public class LoggingServiceAfter implements AfterAdvice {
	Logger logger = Logger.getLogger(LoggingServiceAfterReturning.class);

	@Pointcut("execution(* com.java.controller.*(..))")
	public void logForAllMethods() {
	}

	@After("logForAllMethods()") // after advice with name pointcut that declared as name logForAllMethods()
	public void afterAdviceForAllMethods(JoinPoint jp) throws Throwable {
		System.out.println("Logging after " + jp.getSignature().getName() + " was executed.");
	}

}
