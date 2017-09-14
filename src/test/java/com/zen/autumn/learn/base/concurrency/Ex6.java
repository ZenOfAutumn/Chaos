package com.zen.autumn.learn.base.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sleep implements Runnable{
	
	private static Random rand = new Random(47);
	private final int sleep_time = rand.nextInt(10)+1;
	
	@Override
	public void run() {
		try{
			TimeUnit.SECONDS.sleep(sleep_time);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("sleepTime:"+sleep_time);
		
	}
	
}
public class Ex6 {
	
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			exe.execute(new Sleep());
		}
		exe.shutdown();
		Thread.yield();
		System.out.println("end");
	}
	
	
	

}
