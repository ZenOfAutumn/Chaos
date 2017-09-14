package com.zen.autumn.learn.base.generics;

public class GenericArray<T> {
	
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public GenericArray(int size){
		array = (T[]) new Object[size];
	}
	
	public void put(int index, T item){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] rep(){
		return array;
	}
	
	
	
}
