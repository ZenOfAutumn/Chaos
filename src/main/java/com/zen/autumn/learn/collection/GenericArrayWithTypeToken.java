package com.zen.autumn.learn.collection;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {

	private T[] array;
	
	public GenericArrayWithTypeToken(Class<T> type,int size) {
		this.array = (T[])Array.newInstance(type, size);
	}
	
	
}
