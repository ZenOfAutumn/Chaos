package com.zen.autumn.learn.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapCase {

	

	static void use(){
		IdentityHashMap<Integer, String> lhm =new IdentityHashMap<Integer,String>();
		Integer i = 1234;
		Integer j = 1234;

		HashMap<Integer, String> hm =new HashMap<Integer,String>();
		
		hm.put(i, "");
		hm.put(j, "");
		lhm.put(i, "");
		lhm.put(j, "");
		
		System.out.println(hm.size());
		System.out.println(lhm.size());
			

	}
	
	
	public static void main(String[] args) {
		use();
	}
	
}
