package com.zen.autumn.learn.base.abstractclass;

public class InheritClassOne extends AbstractClassBase {

	@Override
	String f() {
	
		return "One f()";
	}

	@Override
	String g() {
	
		return "One g()";
	}

	
	public static void main(String[] args){
		
		InheritClassOne inhert = new InheritClassOne();
		inhert.print();
		
	}
	
	
}
