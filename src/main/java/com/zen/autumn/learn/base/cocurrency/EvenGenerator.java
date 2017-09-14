package com.zen.autumn.learn.base.cocurrency;

public class EvenGenerator extends IntGenerator {

	
	private int currentValue = 0;
	
	@Override
	public int next() {
		currentValue++;
		currentValue++;
		return currentValue;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator(), 10);
	}

}
