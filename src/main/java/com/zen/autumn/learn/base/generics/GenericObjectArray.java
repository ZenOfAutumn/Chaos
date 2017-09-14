package com.zen.autumn.learn.base.generics;

public class GenericObjectArray<T> {
	
	private Object[] array;
	
	public GenericObjectArray(int size){
		array = new Object[size];
	}
	
	public void put(int index, T item){
		array[index] = item;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index){
		return (T)array[index];
	}
	
	@SuppressWarnings("unchecked")
	public T[] rep(){
		return (T[])array;
	}
	
}
