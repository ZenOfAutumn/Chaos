package com.zen.autumn.learn.base.generics;

public final class Tuple {

	private Tuple() throws IllegalAccessException {
		throw new IllegalAccessException();
	}
	
	public static <A,B> TwoTuple<A, B> tuple(A a,B b){
		return new TwoTuple<A, B>(a, b);
	}
	
	// ......

}
