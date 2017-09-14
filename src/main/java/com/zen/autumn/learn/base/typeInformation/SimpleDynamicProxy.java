package com.zen.autumn.learn.base.typeInformation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Interface {
	void dosomething();

	void somethingelse();
}

class RealObject implements Interface {

	@Override
	public void dosomething() {
		System.out.println("do something");

	}

	@Override
	public void somethingelse() {
		System.out.println("something else");
		// TODO Auto-generated method stub

	}

}

public class SimpleDynamicProxy {

	public static void consumer(Interface iface) {
		iface.dosomething();
		iface.somethingelse();
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[] { Interface.class }, (InvocationHandler) new DynammicProxyHandler(real));
		consumer(proxy);
	}

}

 class DynammicProxyHandler implements InvocationHandler {

	private Object proxied;

	public DynammicProxyHandler(Object proxied) {
		super();
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("***proxy: " + arg0.getClass() + "method: " + arg1 + "args: " + arg2);
		if (arg2 != null) {
			for (Object arg : arg2) {
				System.out.println(arg);
			}
		}
		return arg1.invoke(proxied, arg2);
	}

}
