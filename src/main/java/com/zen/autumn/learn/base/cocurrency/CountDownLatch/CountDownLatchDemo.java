package com.zen.autumn.learn.base.cocurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
	
	static final int SIZE = 10;
	
	
	public static void main(String[] args) {
	
		ExecutorService exe = Executors.newCachedThreadPool();
		
		CountDownLatch latch = new CountDownLatch(SIZE);
		
		for(int i = 0;i<10;i++){
			exe.execute(new WaitingTask(latch));
		}
		
		for(int i = 0;i<SIZE;i++){
			exe.execute(new TaskPortion(latch));
		}
		
		System.out.println("Latched all tasks");
		exe.shutdown();
		
	}

}
