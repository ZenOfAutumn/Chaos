package com.zen.autumn.learn.designPattern.proxy.dynamic;

public class AnotherServiceImpl implements Service {

	@Override
	public String getName(int id) {
		System.out.println("another impl");
		return "another";
	}
	
	@Override
	public Integer getAge(int id) {
		System.out.println("another get age");
		return null;
	}

	
}
