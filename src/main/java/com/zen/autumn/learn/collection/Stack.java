package com.zen.autumn.learn.collection;

import java.util.LinkedList;

public class Stack<E> {
	
	private LinkedList<E> source = new LinkedList<E>();
	
	public void push(E e){
		source.push(e);
	}
	
	public E poll(){
		return source.poll();
	}
	
	public E peek(){
		return source.peek();
	}
	
	
	
	
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<10;i++){
			stack.push(String.valueOf(i));
		}
		
		System.out.println(stack.peek());
		
		String i = null;
		
		while((i = stack.poll())!=null){
			System.out.println(i);
		}
		
		
	}

}
