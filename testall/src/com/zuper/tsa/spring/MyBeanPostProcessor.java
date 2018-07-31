package com.zuper.tsa.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// 只对stu Bean 使用
		if ("stu".equals(beanName)) {
			System.out.println("3' postProcessAfterInitialization" + bean);
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// 只对stu Bean 使用
		if ("stu".equals(beanName)) {
			System.out.println("'3 postProcessAfterInitialization" + bean);
		}
		return bean;
	}

}
