package com.zen.autumn.learn.base.enums;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Case{
	A,B;
}
public class Reflection {
	
	public static Set<String> analysis(Class<?> clazz){
		
		System.out.println("Interfaces: ");
		for(Type t:clazz.getGenericInterfaces()){
			System.out.println(t);
		}
		
		System.out.println("Base: "+clazz.getSuperclass());
		System.out.println("Methods: ");
		Set<String> methods = new TreeSet<String>();
		for(Method m:clazz.getMethods()){
			System.out.println(m.getName());
			methods.add(m.getName());		}
		
		return methods;
		
	}

	
	public static void main(String[] args) {
		Set<String> caseMethods = analysis(Case.class);
		Set<String> enumMethods = analysis(Enum.class);
		System.out.println("==============================");
		System.out.println(caseMethods.containsAll(enumMethods));
		caseMethods.removeAll(enumMethods);
		System.out.println(caseMethods);
	}
}
