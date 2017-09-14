package com.zen.autumn.learn.designPattern.flyweight;

public class ConcreteFlyWeight extends Flyweight {

	@Override
	public void Operation(int ex) {
		System.out.println("concrete" + ex);

	}

}
