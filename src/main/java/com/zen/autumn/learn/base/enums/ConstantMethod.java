package com.zen.autumn.learn.base.enums;

enum AbstractOverride {
	A{
		@Override
		void foo() {
			System.out.println("A");
		}
	};
	
	abstract void foo();
}


enum SuperOverride{
	A{
		@Override
		void foo() {
			System.out.println("A");
		}
	},B;
	
	
	void foo(){
		System.out.println("Foo");
	}
}

interface Interface{
	void foo();	
}

enum InterfaceOverride implements Interface{
	
	A{
		@Override
		public void foo() {
			System.out.println("A");			
		}
	};
	
}

public class ConstantMethod {
	

}
