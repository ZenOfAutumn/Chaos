package com.zen.autumn.learn.designPattern.factory;

public class Minus implements Operation {

	@Override
	public double caculate(double a, double b) {	
		return a-b;
	}

}
