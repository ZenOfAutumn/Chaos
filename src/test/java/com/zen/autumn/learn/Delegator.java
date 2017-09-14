package com.zen.autumn.learn;

class Delagate{
	
	public void foo() {
		
	}
	
	
}

public class Delegator {

	private Delagate delagate;
	
	public Delegator(Delagate delagate) {
		this.delagate = delagate;
	}
	
	public void foo(){
		delagate.foo();
	}
	
	class Delagate{
		
		public void foo() {
			
		}
		
		
	}
}
