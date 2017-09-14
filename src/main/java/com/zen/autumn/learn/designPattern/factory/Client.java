package com.zen.autumn.learn.designPattern.factory;

public class Client {
	
	public static void main(String[] args) {
		double a = 1;
		double b = 2;
		OperationFactory factory = new AddOperationFactory();
		Operation operation = factory.createOperation();
		
		System.out.println(operation.caculate(a, b));
		
	}

}
