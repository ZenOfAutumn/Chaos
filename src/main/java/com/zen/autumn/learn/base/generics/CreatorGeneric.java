package com.zen.autumn.learn.base.generics;

abstract class GenericWithCreate<T> {

	final T element;

	GenericWithCreate() {
		element = create();
	}
	
	abstract T create();
}

class Instance{}

class Creator extends GenericWithCreate<Instance>{

	@Override
	Instance create() {
		
		return new Instance();
	}
	
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
	
}

public class CreatorGeneric {
	
	public static void main(String[] args) {
		Creator c = new Creator();
		c.f();
	}

}
