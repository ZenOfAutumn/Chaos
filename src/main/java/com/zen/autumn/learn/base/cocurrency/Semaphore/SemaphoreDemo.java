package com.zen.autumn.learn.base.cocurrency.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	
	static final int SIZE = 25;
	
	public static void main(String[] args) throws InterruptedException {
		final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);
		ExecutorService exe = Executors.newCachedThreadPool();
		
		for(int i=0;i<SIZE;i++){
			exe.execute(new CheckoutTask<Fat>(pool));
			
		}
		System.out.println("All");
		
		List<Fat> list = new ArrayList<Fat>();
		
		for(int i=0;i<SIZE;i++){
			Fat f = pool.chechOut();
			System.out.println("check out");
			f.toString();
			list.add(f);
		}
		
		Future<?> blocked = exe.submit(new Runnable() {			
			@Override
			public void run() {				
				try{pool.chechOut();}
				catch(InterruptedException e){
					System.out.println();
				}
			}
		});
		
		TimeUnit.SECONDS.sleep(2);
		blocked.cancel(true);
		System.out.println("check in" + list);
		
		for(Fat f:list){
			pool.checkIn(f);
		}
		
		for(Fat f:list){
			pool.checkIn(f);
		}
		
		
		exe.shutdown();
		
		
	}

}
