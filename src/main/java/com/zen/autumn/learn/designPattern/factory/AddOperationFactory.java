package com.zen.autumn.learn.designPattern.factory;

public class AddOperationFactory implements OperationFactory{

	@Override
	public Operation createOperation() {
		return new Add();
	}
	

}
