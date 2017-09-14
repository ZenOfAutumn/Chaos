package com.zen.autumn.learn.designPattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

public class BookServiceFactory {

	private static BookServiceBean service = new BookServiceBean();

	private BookServiceFactory() {
	}

	public static BookServiceBean getInstance() {
		return service;
	}

	public static Object getInstance(Class<?> clazz, Callback callBack, CallbackFilter callbackFilter) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(callBack);
		enhancer.setCallbackFilter(callbackFilter);
		return enhancer.create();
	}

}
