package com.zen.autumn.learn.designPattern.flyweight;

public class UnsharedFlyWeight extends Flyweight {

	@Override
	public void Operation(int ex) {
		System.out.println("unshared fly weight");
	}

}
