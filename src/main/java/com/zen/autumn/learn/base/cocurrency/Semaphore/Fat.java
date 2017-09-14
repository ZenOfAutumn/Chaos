package com.zen.autumn.learn.base.cocurrency.Semaphore;

public class Fat {
	
	private volatile double d;
	private static int counter = 0;
	private final int id = counter ++;
	
	public Fat(){
		for(int i=0;i<10000;i++){
			d+=(Math.E+Math.PI)/(double) i;
		}
	}

	@Override
	public String toString() {
		System.out.println("Fat [d=" + d + ", id=" + id + "]");
		return "Fat [d=" + d + ", id=" + id + "]";

	}

	
	
	
	
}
