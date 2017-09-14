package com.zen.autumn.learn.collection;

interface A{
	
}

class B implements A{
	
}

public class ClassInfo {
	
	static void classInfo(){
		Integer[] is = new Integer[10];
		System.out.println(Integer[].class.getName());
		A a = new B();
		System.out.println(A.class.getName());
		System.out.println();
		System.out.println(a instanceof B);
		System.out.println(B.class.isInstance(a));
		System.out.println(A.class.isAssignableFrom(B.class));
	}

	public static void main(String[] args) {
		classInfo();
		f(new B());
	}
	
	public static <T> void f(T t){
		System.out.println(t.getClass().getSimpleName());
	}
}
