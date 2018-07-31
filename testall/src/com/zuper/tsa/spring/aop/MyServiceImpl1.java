package com.zuper.tsa.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl1 implements MyService{

	@Override
	public void test() {
		System.out.println("service test..");
	}

	@Override
	public int testInt() {
		System.out.println("service testInt..");
		return 1;
	}

	@Override
	public String testString() {
		// TODO Auto-generated method stub
		return "MyServiceImpl1";
	}

}
