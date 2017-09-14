package com.zen.autumn.learn.designPattern.abstractFactory;

public class ConcreteFactoryOne implements AbstractFactory {

	@Override
	public AbstractProductA createProductA() {	
		return new ConcreteProductAA();
	}

	@Override
	public AbstractProductB createProductB() {
		return new ConcreteProductBA();
	}

}
