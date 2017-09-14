package com.zen.autumn.learn.designPattern.bridge;

public class ConcreteImplA  implements Implementor{

	@Override
	public void operation() {
		System.out.println("A op");
	}
}
