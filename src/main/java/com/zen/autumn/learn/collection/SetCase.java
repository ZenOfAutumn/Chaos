package com.zen.autumn.learn.collection;

import java.util.HashSet;

enum E {
	A, B, C;
}

public class SetCase {

	static void use() {

		HashSet<String> ss = new HashSet<String>();
		ss.add("1");
		ss.add("2");
		for (String s : ss) {
			System.out.println(s);
		}

	}

	static void EnumSet() {
		java.util.EnumSet<E> e = java.util.EnumSet.noneOf(E.class);
		e.add(E.A);
		e.add(E.B);

		for (E es : e) {
			System.out.println(es);
		}

	}

	public static void main(String[] args) {
		EnumSet();
	}

}
