package com.zen.autumn.learn.base.innerclass.closure;

public class CalleeTwo {
	
	private int i = 0;
	

	public void increment(){
	
		i++;
		System.out.println(i);
	}
	
	private class Closure implements Incrementable{

		@Override
		public void increment() {
			CalleeTwo.this.increment();			
		}
		
	}
	
	Incrementable getCallbackReference(){
		return new Closure();
	}

}
