package com.zen.autumn.learn.base.innerclass.closure;

public class Callbacks {

	
	public static void main(String[] args){
	
		CalleeTwo callTwo = new CalleeTwo();		
		Caller c2 = new Caller(callTwo.getCallbackReference());

		c2.go();
		System.out.println("====================================");

		c2.go();
		System.out.println("====================================");

		
	}
}
