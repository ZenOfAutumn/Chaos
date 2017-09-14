package com.zen.autumn.learn.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueCase {

	static class Com implements
	 Comparable<Com>{
		public int i;

		public Com(int j) {
			i = j;
		}

		@Override
		public int compareTo(Com o) {
			return this.i-o.i;
		}
	}

	static void use() {
		Comparator<Com> com = new Comparator<PriorityQueueCase.Com>() {
			@Override
			public int compare(Com o1, Com o2) {
				return o1.compareTo(o2);
			}
		};

		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		for(int j:new int[]{2,5,1,3,6,4,4}){
			p.add(j);
		}
		
		Integer i;
		do{
			 i = p.poll();
			System.out.println(i);
		}while(i != null);
	
	}
	
	public static void main(String[] args) {
		use();
	}

}
