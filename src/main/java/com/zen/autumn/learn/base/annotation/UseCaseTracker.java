package com.zen.autumn.learn.base.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
	
	public static void trackUseCases(List<Integer> useCases,Class<?>cls){
		
		for(Method m:cls.getDeclaredMethods()){
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null){
				System.out.println("Found Use Case:"+uc.id()+" "+uc.description());
				useCases.remove(new Integer(uc.id()));			
			}
			
		}
		for(Integer i : useCases){
			System.err.println("miss" + i);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases,47,48,49,50);
		System.out.println(useCases);
		
		trackUseCases(useCases, PasswordUtils.class);		
	}

}
