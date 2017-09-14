package com.zen.autumn.learn.designPattern.proxy.dynamic;

public class ServiceImpl implements Service {

	@Override
	public String getName(int id) {
		System.out.println("------getName------");
		return "Tom";
	}

	@Override
	public Integer getAge(int id) {
		System.out.println("------getAge------");
		return 10;
	}

}
