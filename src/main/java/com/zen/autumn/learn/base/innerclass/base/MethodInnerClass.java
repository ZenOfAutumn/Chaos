package com.zen.autumn.learn.base.innerclass.base;



public class MethodInnerClass {
	
	
	interface Inner{}
	
	public static Inner foo(){
		
		{
			class FieldInnerClass implements Inner{
				static final String NAME = "BEAUTIFUL";
			}
			
			System.out.println(FieldInnerClass.NAME);
		}
		
		// FieldInnerClass.NAME; wont't compile
		
		class InnerClass implements Inner {
				
		}
		
		return new InnerClass();
	}
	
	
	public static void main(String[] args) {
		MethodInnerClass.foo();
	}

}
