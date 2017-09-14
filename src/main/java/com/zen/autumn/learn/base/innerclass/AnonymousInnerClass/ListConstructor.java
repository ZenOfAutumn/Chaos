package com.zen.autumn.learn.base.innerclass.AnonymousInnerClass;

import java.util.ArrayList;
import java.util.List;

public class ListConstructor {

	public static void main(String[] args) {
		List<String> doubleBracketInitialize = new ArrayList<String>() {
			{
				add("hello");
				add("world");
			}
		};
		
		for(String item:doubleBracketInitialize){
			System.out.println(item);
		}
	}

}
