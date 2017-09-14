package com.zen.autumn.learn.base.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Location {

	private int x;

	private int y;

	 synchronized void  operation() {
		x++;
		Thread.yield();
		y++;
	}
	
	@Override
	public synchronized String toString() {
		return "x:"+ x+" y:"+y;
	}
}


class UnTask implements Runnable{
	
	private Location location;
	
	public UnTask(Location location) {
		this.location = location;		
	}
	
	@Override
	public void run() {
		location.operation();
		Thread.yield();
		System.out.println(Thread.currentThread().toString()+location);
	}
}

public class Ex11 {
	
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		Location location = new Location();
		for(int i =0;i<100;i++){
			exe.execute(new UnTask(location));
		}
		exe.shutdown();		
	}
	
	
}
