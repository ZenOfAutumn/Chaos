package com.zen.autumn.learn.base.generics;

interface Face {
	String getFace();
}

class Book {

	public void getBook() {
		System.out.println("Book");
	}
}

class FaceBook<T extends Book & Face> {

	T item;

	public String  getFace(){
		return item.getFace();
	}

	public void getBook() {
		item.getBook();
	}
}

public class Border {

}
