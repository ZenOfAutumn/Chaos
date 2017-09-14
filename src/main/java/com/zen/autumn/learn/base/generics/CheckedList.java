package com.zen.autumn.learn.base.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;


class Cat{}
class Dog{}

public class CheckedList {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void oldStyleMethod(List probablyDogs){
		probablyDogs.add(new Cat());
	}	
	
	public static void main(String[] args) {
		List<Dog> dogs = Lists.newArrayList();
		oldStyleMethod(dogs);
		
		List<Dog> dogss = Collections.checkedList(new ArrayList<Dog>(),Dog.class);		
		oldStyleMethod(dogss);
	}	

}
