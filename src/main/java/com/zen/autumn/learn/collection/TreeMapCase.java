package com.zen.autumn.learn.collection;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapCase {
	
	static void use(){
		TreeMap<Integer,String> em = new TreeMap<Integer,String>();
		
		for(int i = 5;i>0;i--){
			em.put(i, String.valueOf(i));
		}
		
		for(Entry<Integer, String> entry:em.entrySet()){
			System.out.println(entry.getKey());
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		use();
		
	}
	

}
