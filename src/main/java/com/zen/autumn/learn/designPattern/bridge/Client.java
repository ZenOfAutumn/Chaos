package com.zen.autumn.learn.designPattern.bridge;

public class Client {
	
	public static void main(String[] args) {
	 Abstraction ab = new RefinedAbstraction();
	 ab.setImpl(new ConcreteImplA());
	 
	 ab.operation();
	 
	 ab.setImpl(new ConcreteImplB());
	 
	 ab.operation();
		
	}

}
