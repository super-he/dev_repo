package com.zuper.tsa.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * 实现一个FactoryBean
 * 
 * @author Super
 * 
 */
public class StudentFactoryBean implements FactoryBean<Student> {
	private Integer id;
	private String name;

	@Override
	public Student getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Student(id, name);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Student.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		// return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
