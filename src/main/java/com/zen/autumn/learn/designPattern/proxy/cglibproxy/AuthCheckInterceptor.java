package com.zen.autumn.learn.designPattern.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AuthCheckInterceptor implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	private String name;

	public AuthCheckInterceptor(String name) {
		this.name = name;
	}

	public Object getDaoBean(Class cls) {
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.err.println(method.getName());
		Object result = proxy.invokeSuper(obj, args);
		return result;

	}

}
