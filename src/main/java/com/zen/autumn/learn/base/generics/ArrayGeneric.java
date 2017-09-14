package com.zen.autumn.learn.base.generics;


class Fruit{}

class Apple extends Fruit{}

class Orange extends Fruit{}

class Jonathan extends Apple{}


public class ArrayGeneric {
	
	public static void main(String[] args) {
		Fruit[] fruitArray = new Apple[10];
		
		fruitArray[0] = new Apple();
		fruitArray[1] = new Jonathan();
		fruitArray[2] = new Orange();
		fruitArray[3] =  new Fruit();
	}

}
