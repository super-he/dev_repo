package com.zuper.tsa.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LoggingAspect {
//	@Before("execution(* com.zuper.tsa.spring.aop.MyService.test*())")
	public void beforeMethod(JoinPoint joinpoint){
		System.out.println("print before method..");
		System.out.println("aim method's name is " + joinpoint.getSignature().getName());
		System.out.println("aim method's args is " + Arrays.asList(joinpoint.getArgs()));
	}
}
