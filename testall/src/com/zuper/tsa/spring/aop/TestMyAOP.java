package com.zuper.tsa.spring.aop;

public class TestMyAOP {
	public static void main(String[] args) {
		MyService target = new MyServiceImpl1();
		target.test();
		System.out.println(target.testInt());
		System.out.println(target.testString());
		System.out.println("---proxy---");
		
		MyService proxy = new MyServiceLoggingHandler(target).getMyLoggingProxy();
		proxy.test();
		System.out.println(proxy.testInt());
		System.out.println(proxy.testString());
		
	}
}
