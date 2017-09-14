package com.zen.autumn.learn.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreCase {

	private Semaphore s = new Semaphore(0);
	
	private int i = 0;
	
	public void read() throws InterruptedException{
		s.acquire();
		i++;
		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName() + " " + i);
		s.release();
	}
	
	
	public void release() throws InterruptedException{
		s.release();
	}
	
	public  int state(){
		return s.availablePermits();
	}
	
	public static void main(String[] args) {
		final SemaphoreCase cas = new SemaphoreCase();
		
		System.out.println(cas.state());
		try {
			cas.release();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(cas.state());

		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						cas.read();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		
		
		for(int i = 0;i<2;i++){
			new Thread(r).start();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
