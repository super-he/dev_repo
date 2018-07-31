package com.zuper.tsa.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {
	@Test
	public void testIOC() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"config/spring/beans.xml");
		Student stu = (Student) ctx.getBean("stu");
		System.out.println(stu);

		MyDataSource mds = (MyDataSource) ctx.getBean("myDataSource");
		System.out.println(mds);

		Student stu2 = (Student) ctx.getBean("stu2");
		System.out.println(stu2);

		Student stu3 = (Student) ctx.getBean("stu3");
		System.out.println(stu3);

		Student stu4 = (Student) ctx.getBean("stu4");
		System.out.println(stu4);

		Student stu5 = (Student) ctx.getBean("stu5");
		System.out.println(stu5);

		BaseService<Student> stuService = (BaseService<Student>) ctx
				.getBean("studentService");
		stuService.test();

		((AbstractApplicationContext) ctx).close();
	}

}
