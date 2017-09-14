package com.zen.autumn.learn.collection;

import java.util.LinkedList;

public class Queue<E> {
	private LinkedList<E> source = new LinkedList<E>();
	
	public void add(E e){
		source.addLast(e);
	}
	
	public E get(){
		return source.pollFirst();
	}
	
	
	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		for(int i=0;i<10;i++){
			q.add(String.valueOf(i));
		}
		
		System.out.println(q.get());
		
		String i = null;
		
		while((i = q.get())!=null){
			System.out.println(i);
		}
		
	}

	
}
