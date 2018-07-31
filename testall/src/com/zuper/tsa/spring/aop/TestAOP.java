package com.zuper.tsa.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	@Test
	public void testAspectJ(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/aop.xml");
		MyService service = ctx.getBean(MyService.class);
		service.test();
		System.out.println(service.testString());
	}
}
