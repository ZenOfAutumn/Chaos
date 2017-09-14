package com.zen.autumn.learn.designPattern.singleton;

public class EagerSingleton {
	
	private static EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton(){
		
	}
	
	public static EagerSingleton getInstance() {
		return instance;
	}

}
