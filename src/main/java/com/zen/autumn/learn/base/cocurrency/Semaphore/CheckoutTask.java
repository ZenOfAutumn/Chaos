package com.zen.autumn.learn.base.cocurrency.Semaphore;

import java.util.concurrent.TimeUnit;

public class CheckoutTask<T> implements Runnable {
	
	private static int counter = 0;
	@SuppressWarnings("unused")
	private final int id = counter++;
	private Pool<T> pool;
	
	public CheckoutTask(Pool<T> pool) {
		this.pool = pool;
	}
	
	@Override
	public void run() {

		try{
			T item = pool.chechOut();
			System.out.println("out" + item);
			TimeUnit.SECONDS.sleep(1);
			System.out.println("in"+ item);
			pool.checkIn(item);
			
		}catch(InterruptedException e){
			
		}
		
	}	
	
	
}
