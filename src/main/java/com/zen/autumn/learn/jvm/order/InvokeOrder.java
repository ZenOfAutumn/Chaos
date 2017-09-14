package com.zen.autumn.learn.jvm.order;

interface I{
	void f();
}

class C implements I{

	@Override
	public void f() {
	}
	
}

class Invoke {
	
	void iv(){
		C c = new C();
		c.f();
	}
	
	void ii(){
		I c = new C();
		c.f();
	}
}

public class InvokeOrder {

}
