package com.zen.autumn.learn.designPattern.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class ProxyFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		 if(!"query".equalsIgnoreCase(method.getName()))     
	            return 0;     
	        return 0;   
	}

}
