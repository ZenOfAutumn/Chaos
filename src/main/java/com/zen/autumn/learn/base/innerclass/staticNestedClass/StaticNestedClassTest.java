package com.zen.autumn.learn.base.innerclass.staticNestedClass;

import com.zen.autumn.learn.base.innerclass.staticNestedClass.StaticNestedClass.ProtectedStaticNestedClass;
import com.zen.autumn.learn.base.innerclass.staticNestedClass.StaticNestedClass.PublicStaticNestedClass;

public class StaticNestedClassTest {
	
	PublicStaticNestedClass publicStaticNestedClass;
	
	
	
	public StaticNestedClassTest(PublicStaticNestedClass publicStaticNestedClass) {
		super();
		this.publicStaticNestedClass = publicStaticNestedClass;
	}

	
	public void f(){
		publicStaticNestedClass.function();
	}


	public static void main(String[] args){
	
		StaticNestedClassTest test = new StaticNestedClassTest(new PublicStaticNestedClass());
		test.f();
	
	ProtectedStaticNestedClass protectedStaticNestedClass = new ProtectedStaticNestedClass();
	protectedStaticNestedClass.function();
	
	
	
	}

}
