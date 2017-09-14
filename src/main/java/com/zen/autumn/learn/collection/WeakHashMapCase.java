package com.zen.autumn.learn.collection;

import java.util.WeakHashMap;

public class WeakHashMapCase {

	
	static void use(){
		WeakHashMap<Integer, Object> whm = new WeakHashMap<Integer, Object>();
		Object l = new Integer(666);
		Object n = new Integer(888);
		whm.put(1456,l);
		whm.put(2234,n);
		n = null;
		Object c = new Object();
		
		System.gc();
		System.gc();
		System.out.println(whm.size());
		System.out.println(whm.get(1456));
		System.out.println(whm.get(2234));
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		use();
	}
	
}
