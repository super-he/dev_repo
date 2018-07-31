package com.zuper.tsa.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.zuper.tsa.spring.BaseService;

/**
 * 自己运用动态代理实现AOP 抽出Service层的日志功能
 * 
 * @author Super
 * 
 */
public class MyServiceLoggingHandler {
	private MyService target;

	public MyServiceLoggingHandler(MyService target) {
		this.target = target;
	}

	public MyService getMyLoggingProxy() {
		MyService proxy = null;

		// 代理对象的类加载器
		ClassLoader loader = target.getClass().getClassLoader();
		// 代理对象的类型
		Class[] interfaces = new Class[] { MyService.class };
		// 调用代理对象方法时，要执行的代码
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy:目标对象（一般不会再invoke中使用proxy，因为会掉入死循环->内存溢出） 
			 * method：正在被调用的方法 
			 * args：调用方法传入的参数
			 * 返回值：方法的返回值 --就是除了可以增加行为外，还可以改变返回值，这就很吊比了
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// 正在调用的方法的方法名
				System.out.println("target's method: " + method.getName());
				// 调用方法
				Object rs = null;
				try {
					//... 前置通知，目标方法执行之前
					rs = method.invoke(target, args); //执行目标方法
					//... 返回通知，可以访问到返回值
				} catch (Exception e) {
					e.printStackTrace();
					//... 异常通知，可以访问到出现的异常对象
				}
				//... 后置通知，由于方法可能出现异常，所以访问不了返回值
				System.out.println("logging added..");
				//方法的返回值
				Object rs1 = 1111;
				if(rs==null || rs1.getClass().equals(rs.getClass())){
					return rs1;
				}
				return rs;
			}
		};
		proxy = (MyService) Proxy.newProxyInstance(loader, interfaces, h);

		return proxy;
	}
}
