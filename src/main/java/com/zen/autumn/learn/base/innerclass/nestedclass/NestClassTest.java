package com.zen.autumn.learn.base.innerclass.nestedclass;

import com.zen.autumn.learn.base.innerclass.nestedclass.NestClassItem.NestClass;

public class NestClassTest {

	private NestClass nest;

	public NestClass getNest() {
		return nest;
	}

	public void setNest(NestClass nest) {
		this.nest = nest;
	}

	public static void main(String[] args) {
		NestClass nest = new NestClass("hello");
		nest.Print();
		NestClassInInterface.NestClass nestInInter = new NestClassInInterface.NestClass();
		nestInInter.print();
	}
}
