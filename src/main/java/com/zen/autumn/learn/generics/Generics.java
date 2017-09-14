package com.zen.autumn.learn.generics;

interface A {
	void foo();
}

class B implements A {
	public void foo() {
		System.out.println(Thread.currentThread().getName());
	}
}

class C extends B{
	
}

class O{
	private Generics<C> p;
}


public class Generics<T extends B> {

	T t;

	void dis() {
		t.foo();
	}

}
