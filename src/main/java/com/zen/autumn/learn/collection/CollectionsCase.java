package com.zen.autumn.learn.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsCase {

	static void synchronize() {
		
	}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void check() {
		Collection coll = new LinkedList<Integer>();
		coll.add(1);
		Collection get = Collections.checkedCollection(coll, Integer.class);
		coll.add(1L);
		coll.add("1234");
		Iterator it = coll.iterator();
		while(it.hasNext()){
			Object c = it.next();
			System.out.println(c.getClass().getSimpleName());
		}
	}

	static void unmodify() {
		Collection<Integer> coll = new LinkedList<Integer>();
		coll.add(1);
		Collection<Integer> get = Collections.unmodifiableCollection(coll);
		coll.add(2);
		for (Integer u : get) {
			System.out.println(u);
		}
		get.add(3);
	}

	public static void main(String[] args) {
		try {
			unmodify();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			check();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
