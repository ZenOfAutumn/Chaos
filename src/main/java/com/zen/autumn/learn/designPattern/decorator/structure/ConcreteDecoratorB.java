package com.zen.autumn.learn.designPattern.decorator.structure;

public class ConcreteDecoratorB extends Decorator {

	@SuppressWarnings("unused")
	private String operation;
	
	@Override
	public void operation() {
		System.out.println("B operation");
		super.operation();	
		AddedBehavior();
		
	}
	
	
	private void AddedBehavior(){
		
	}
}
