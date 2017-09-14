package com.zen.autumn.learn.base.cocurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeamonThreadFactoryUseCase implements Runnable {

	@Override
	public void run() {
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+ this);
			}
		}catch(InterruptedException e){
			System.out.println("sleep() Interupted");
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		 ExecutorService exe = Executors.newCachedThreadPool(new DeamonThreadFactory());
		 
		 for(int i = 0;i<10;i++){
			 exe.execute(new DeamonThreadFactoryUseCase());
		 }
		
		System.out.println("all deamon start");
		TimeUnit.MILLISECONDS.sleep(50);
		
	}

	
	
}
