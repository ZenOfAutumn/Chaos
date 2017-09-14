package com.zen.autumn.learn.base.cocurrency.ThreadLocal;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

 class Accessor implements Runnable {
	
	private final int id;
	
	public Accessor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVaraiableHolder.increment();
			System.out.println(this);
			Thread.yield();
			
		}
	}

	@Override
	public String toString() {
		return "Accessor [id=" + id + "]"+ThreadLocalVaraiableHolder.get();
	}
	
	
	

}


public class ThreadLocalVaraiableHolder{
	
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
		
		private Random rand = new Random(47);
		
		@Override
		protected synchronized Integer initialValue(){
			return rand.nextInt(10000);
		}
	};
	
	public static void increment(){
		value.set(value.get()+1);
	}
	
	public static int get(){
		return value.get();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(ThreadLocalVaraiableHolder.get());
		
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i = 0;i<5;i++){
			exe.execute(new Accessor(i));
		}
		
		TimeUnit.SECONDS.sleep(3);
		exe.shutdown();
	}
	
	
}