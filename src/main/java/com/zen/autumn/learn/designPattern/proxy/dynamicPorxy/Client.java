package com.zen.autumn.learn.designPattern.proxy.dynamicPorxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		
		Subject sb = new SubjectImpl();

		InvocationHandler handler = new DynamicProxy(sb);

		Subject sbt = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
				sb.getClass().getInterfaces(), handler);
		
		System.out.println(sbt.getClass().getName());
		
		sbt.rent();
		sbt.hello("world");
		
		

	}

}
