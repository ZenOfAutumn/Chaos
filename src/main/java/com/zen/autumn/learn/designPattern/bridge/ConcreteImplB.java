package com.zen.autumn.learn.designPattern.bridge;

public class ConcreteImplB  implements Implementor{

	@Override
	public void operation() {
		System.out.println("B op");
	}
}
