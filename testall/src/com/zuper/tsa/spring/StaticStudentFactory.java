package com.zuper.tsa.spring;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂
 * 
 * @author Super
 * 
 */
public class StaticStudentFactory {
	private static Map<String, Student> stus = new HashMap<>();

	static {
		stus.put("hewc", new Student(1, "hewc"));
		stus.put("zhaozq", new Student(2, "zhaozq"));
		stus.put("hux", new Student(3, "hux"));
	}

	public static Student getStu(String name) {

		return stus.get(name);
	}
}
