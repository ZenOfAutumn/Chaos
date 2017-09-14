package com.zen.autumn.learn;

public class Override {

	
	
	public void Cons(){
		Constructor cons = new Constructor();
	}
	
	public static void main(String[] args) {

		Base base = (Base)new Extend();
		base.staticGet();
		base.dynamicGet();
		
		Extend extend = (Extend) base;
		extend.staticGet();
		extend.dynamicGet();
		

	}

}


class Constructor{
	
	private String ll;
	
	public Constructor() {
	
		this.ll = cons();
		System.err.println(ll);
	}
	
  public static String cons(){
	  
	  return "1";
  }
}

class Base {
	private String pr;

	public String hello = "base";

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	private void foo() {

		System.err.println("base foo");
	}
	
	public static void staticGet(){
		System.err.println("static base");
	}
	
	public void dynamicGet(){
		
		System.err.println("dynamic base");
	}
}

class Extend extends Base {

	public Extend() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String hello = "extend";

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	public void foo() {

		System.err.println("extend foo");
	}
	
	public static void staticGet(){
		System.err.println("static extend");
	}
	
	public void dynamicGet(){
		
		System.err.println("dynamic extend");
	}
	
	
}
