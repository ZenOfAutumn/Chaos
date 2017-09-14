package com.zen.autumn.learn.base.cocurrency.Interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class InterruptTask implements Runnable{
	
	
	
	
	
	@Override
	public void run() {

		try{
			while(!Thread.currentThread().isInterrupted()){
				Thread.sleep(100);
			}
		}catch(InterruptedException e){
			System.out.println(Thread.currentThread().getName() + " interrupted.");
		}
		
		
		
	}
}


public class ExecutorServiceInterrupt {

	public static void main(String[] args) {
	
		ExecutorService exe = Executors.newCachedThreadPool();
		
		
		for(int i=0;i<10;i++){
			exe.execute(new InterruptTask());
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		exe.shutdownNow();
		
		
		
		
		
		
		
	}
	
	
	
}
