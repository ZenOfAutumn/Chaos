package com.zen.autumn.learn.collection;

import java.util.EnumMap;


enum Key{
	L,
	M,
	N;
}

public class EnumMapCase {
	
	static void use(){
		EnumMap<Key,Integer> em = new EnumMap(Key.class);
		em.put(Key.L, 1);
		System.out.println(em.keySet());

	}
	
	public static void main(String[] args) {
		use();
	}

}
