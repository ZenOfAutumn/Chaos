package com.zen.autumn.learn.collection;

import java.util.ArrayDeque;

public class ArrayDequeCase {
	
	
	
	static void use(){
		
		ArrayDeque<String> deque = new ArrayDeque<String>();
		for(int i = 0;i<10;i++){
			deque.offerLast(String.valueOf(i));
		}
		
		System.out.println(deque.size());
	}
	
	
	static void sizeVerify(){
		int i = 9;
		int size = 16;
		
		int next = (i+1)%size;
		System.out.println(next);
		
		int nextn = (i+1)&(size -1);
		System.out.println(nextn);
		
	}
	
	
	public static void main(String[] args) {
		sizeVerify();
	}

}
