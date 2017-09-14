package com.zen.autumn.learn.designPattern.decorator.structure;

public class ConcreteDecoratorA  extends Decorator{ 

	private String addedState;
	
	@Override
	public String toString() {
		return addedState;
	}
	
	@Override
	public void operation() {
		super.operation();
		this.addedState = "New State";
		System.out.println("A decoration");
	}	
}
