package com.zen.autumn.learn.designPattern.bridge;

public  abstract class Abstraction {
	
	protected Implementor impl;
	
	
	public void setImpl(Implementor impl) {
		this.impl = impl;
	}
	
	abstract void operation();

}
