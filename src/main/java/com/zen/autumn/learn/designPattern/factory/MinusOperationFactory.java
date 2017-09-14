package com.zen.autumn.learn.designPattern.factory;

public class MinusOperationFactory implements OperationFactory {

	@Override
	public Operation createOperation() {
		return new Minus();
	}

}
