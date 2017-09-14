package com.zen.autumn.learn.designPattern.adapter;

public class Client {
	
	public static void main(String[] args) {
		
		
		Duck duck = new TurkeyAdapter(new WildTrukey());
		
		duck.quack();
		duck.fly();
	}

}
