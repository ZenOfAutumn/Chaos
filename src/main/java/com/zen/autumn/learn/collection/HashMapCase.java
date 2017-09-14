package com.zen.autumn.learn.collection;

import java.util.HashMap;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;

public class HashMapCase {

	
	static MapJoiner J = Joiner.on("|").withKeyValueSeparator("=");
	
	static void use() {
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		for (int i = 0; i < 10; i++) {
			m.put(String.valueOf(i), i);
		}

		m.remove("1");
		System.out.println(J.join(m));
		m.put("2", 3);
		System.out.println(J.join(m));
		
		
	}
	
	
	
	public static void main(String[] args) {
		use();
	}

}
