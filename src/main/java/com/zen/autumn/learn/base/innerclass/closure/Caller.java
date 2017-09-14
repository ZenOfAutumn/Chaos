package com.zen.autumn.learn.base.innerclass.closure;

public class Caller {
	
	private Incrementable callbackReference;

	public Caller(Incrementable callbackReference) {
		super();
		this.callbackReference = callbackReference;
	}
	
	void go(){
		callbackReference.increment();
	}

}
