package com.zen.autumn.learn.base.collection;

import java.util.PriorityQueue;

public class ToDoList  extends PriorityQueue<ToDoList.ToDoItem>{

	
	static class ToDoItem implements Comparable<ToDoItem>{
		
		char p;
		int s;
		String item;
		
		@Override
		public int compareTo(ToDoItem o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
		
	}
	
	
	
}
