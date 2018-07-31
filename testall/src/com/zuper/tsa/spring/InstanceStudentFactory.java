package com.zuper.tsa.spring;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂
 * @author Super
 *
 */
public class InstanceStudentFactory {
	private Map<String, Student> stus = null;
	
	public InstanceStudentFactory() {
		stus = new HashMap<>();
		stus.put("hewc", new Student(1, "hewc"));
		stus.put("zhaozq", new Student(2, "zhaozq"));
		stus.put("hux", new Student(3, "hux"));
	}


	public Student getStu(String name) {

		return stus.get(name);
	}
}
