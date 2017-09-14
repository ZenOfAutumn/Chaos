package com.zen.autumn.learn;

public abstract class AbstractMethod {
	
	abstract void f();
	
	public static void main(String[] args) {
	
		int i =0 ;
		
		AbstractMethod ab = new AbstractMethod() {
			
			void f() {
				System.out.println(i);
			}
		};
		
		ab.f();
	}

}
