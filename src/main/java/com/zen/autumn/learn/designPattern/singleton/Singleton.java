package com.zen.autumn.learn.designPattern.singleton;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton() throws IllegalAccessError {
		if (instance != null) {
			throw new IllegalAccessError();
		}
	}

	public static Singleton getInstance() {		
		return instance;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Constructor<Singleton> con = Singleton.class.getDeclaredConstructor();
		AccessibleObject.setAccessible(new AccessibleObject[] { con }, false);
		Singleton reflect = con.newInstance();
		System.out.println(reflect == getInstance());

	}

}
