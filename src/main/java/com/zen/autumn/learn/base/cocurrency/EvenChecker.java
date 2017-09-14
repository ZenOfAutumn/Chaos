package com.zen.autumn.learn.base.cocurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
	
	private IntGenerator gen;
	
	@SuppressWarnings("unused")
	private final int id;	
	
	public  EvenChecker(IntGenerator gen,int id) {
		this.gen = gen;
		this.id = id;
	}

	@Override
	public void run() {
		
		while(!gen.isCanceled()){
			int val = gen.next();
			if(val%2 !=0){
				System.out.println(val+"not even");
				gen.cancel();
			}
		}
	}
	
	
	public static void test(IntGenerator gen,int count){
		System.out.println("111");
		
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i = 0;i<count;i++){
			exe.execute(new EvenChecker(gen, i));
		}
		exe.shutdown();
	}
	
	

}
