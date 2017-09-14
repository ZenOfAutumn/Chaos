package com.zen.autumn.learn.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapCase {
	
	
	static void use(){
		LinkedHashMap<String, Integer> lhm =new LinkedHashMap<String,Integer>();
		for(int i = 10;i>0;i--){
			lhm.put(String.valueOf(i), i);
		}
		
		for(String k:lhm.keySet()){
			System.out.println(k);
		}
	}
	static void access(){
		LinkedHashMap<String, Integer> lhm =new LinkedHashMap<String,Integer>(10,0.7f,true);
		for(int i = 10;i>0;i--){
			lhm.put(String.valueOf(i), i);
		}
		
		System.out.println(lhm.get("5"));
		
		
		for(Map.Entry<String,Integer> m:lhm.entrySet()){
			System.out.println(m.getKey()+":"+m.getValue());
		}
		
		for(String k:lhm.keySet()){
			System.out.println(k);
		}
		
	}
	
	
	public static void main(String[] args) {
		access();
	}

}
