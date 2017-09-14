package com.zen.autumn.learn.designPattern.adapter;

public class MallardDuck implements Duck {

	@Override
	public void quack() {
		System.out.println("quack");

	}

	@Override
	public void fly() {
		System.out.println("fly");
	}

}
