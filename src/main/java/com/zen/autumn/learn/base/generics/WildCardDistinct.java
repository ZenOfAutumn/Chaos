package com.zen.autumn.learn.base.generics;

import java.util.ArrayList;
import java.util.List;

class A{}

class B{}

public class WildCardDistinct {

	public static void main(String[] args) {

		List list = new ArrayList();

		list.add(new Object());
		
		list.add(new A());
		
		List<?> listCom = new ArrayList<A>();

		
		
		
	}

}
