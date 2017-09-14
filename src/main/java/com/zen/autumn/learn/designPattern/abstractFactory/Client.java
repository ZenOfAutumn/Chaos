package com.zen.autumn.learn.designPattern.abstractFactory;

public class Client {

	public static void main(String[] args) {
		AbstractFactory AbF = new ConcreteFactoryOne();
		AbstractProductA AbA = AbF.createProductA();
		AbstractProductB AbB = AbF.createProductB();
		
		AbA.insert();
		AbB.select();
	}
}
