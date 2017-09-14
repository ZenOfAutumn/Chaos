package com.zen.autumn.learn.base.generics;

class Base {
}

class Derived   {
}

class GenericSetter<T> {
	void set(T arg) {
		System.out.println(this.getClass().getSimpleName() + "set(Base)");
	}
}

class DerivedGS extends GenericSetter<Base> {
	void set(Derived derived) {
		System.out.println(this.getClass().getSimpleName() + "set(derived)");
	}
}

public class PlainGenericInheritance{
	
	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		DerivedGS dgs = new DerivedGS();
		dgs.set(base);
		dgs.set(derived); // overloaded not overridden!
	}
	
}

// DerivedGSset(Base)
// DerivedGSset(derived)



 
