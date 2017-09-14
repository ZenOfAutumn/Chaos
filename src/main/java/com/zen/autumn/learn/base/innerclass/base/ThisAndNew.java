package com.zen.autumn.learn.base.innerclass.base;

class OuterClass{
	
	class InnerClass{		
		private OuterClass getOuter(){
			return OuterClass.this;
		}
	}
	
}

public class ThisAndNew {
	
	public static void main(String[] args) {
		
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		
	}
	
	
	
	

}
