package com.zen.autumn.learn.designPattern.bridge;

public class RefinedAbstraction extends Abstraction{
	
	@Override
	public void operation() {
		impl.operation();
	}
	
}
