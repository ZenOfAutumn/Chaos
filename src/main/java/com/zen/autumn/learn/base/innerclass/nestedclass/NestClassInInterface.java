package com.zen.autumn.learn.base.innerclass.nestedclass;

public interface NestClassInInterface {

	void print();
	
	public static class NestClass  implements NestClassInInterface{

		public void print() {
			System.out.print("This is nested class in interface");		
		} 
		
	}
	
}
