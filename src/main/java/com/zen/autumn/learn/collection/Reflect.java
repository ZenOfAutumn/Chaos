package com.zen.autumn.learn.collection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.apache.commons.collections.CursorableLinkedList;

public class Reflect {
	
	
	static void dis(Class clazz){
		for(Method ms:clazz.getDeclaredMethods()){
			if(Modifier.isPublic(ms.getModifiers())){
				System.out.println(clazz.getSimpleName() +" "+ ms.getName()+Arrays.toString(ms.getParameters()));
			}
		}
	}
	
	static  void displayMethod(Class clazz){
		
		dis(clazz);
		Class superC = clazz.getSuperclass();
		while(!superC.equals(Object.class)){
			dis(superC);
			superC = superC.getSuperclass();
		}
	}
	
	static void disF(Class clazz){
		for(Field ms:clazz.getDeclaredFields()){
			if(!Modifier.isStatic(ms.getModifiers())){
				System.out.println(clazz.getSimpleName() +" "+ ms.getType().getSimpleName()+" "+ ms.getName());
			}
		}
	}
	
	static void displayField(Class clazz){
		disF(clazz);
		Class superC = clazz.getSuperclass();
		while(!superC.equals(Object.class)){
			disF(superC);
			superC = superC.getSuperclass();
		}
		
	}
	

	public static void main(String[] args) {
		displayField(CursorableLinkedList.class);

//		displayMethod(ThreadPoolExecutor.class);

	}

}
