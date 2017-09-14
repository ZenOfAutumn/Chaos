package com.zen.autumn.learn.designPattern.prototype;

public interface ConstructorCopy<T extends ConstructorCopy<T>> {

	
	 T copy(T src);
}
