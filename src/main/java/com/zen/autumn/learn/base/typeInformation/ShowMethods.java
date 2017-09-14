package com.zen.autumn.learn.base.typeInformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
	
	private static Pattern pattern = Pattern.compile("\\w+\\.");
	
	public static void main(String[] args) throws ClassNotFoundException{
		Class<?>  cls = Class.forName("java.lang.Integer");
		Method[] methods = cls.getMethods();
		Constructor[] ctors = cls.getConstructors();
		
		for(Method mthod:methods){
			System.out.println(mthod.toString());
		
		}
		
		
		for(Constructor ctor:ctors){
			System.out.println(ctor.toString());
		}	
		
		
		
		
	}

}
