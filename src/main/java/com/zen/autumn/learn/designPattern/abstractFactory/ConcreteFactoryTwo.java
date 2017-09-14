package com.zen.autumn.learn.designPattern.abstractFactory;

public class ConcreteFactoryTwo implements AbstractFactory {

	@Override
	public AbstractProductA createProductA() {	
		return new ConcreteProductAB();
	}

	@Override
	public AbstractProductB createProductB() {
		return new ConcreteProductBB();
	}

}
