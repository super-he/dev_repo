package com.zuper.tsa.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	@Autowired
	protected BaseDao<T> dao;

	public void test() {
		dao.test();
	}
}
