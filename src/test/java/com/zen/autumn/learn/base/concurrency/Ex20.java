package com.zen.autumn.learn.base.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class InterruptedTask implements Runnable{
	
	private int id = 8;
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		while(id > 0){
			if(Thread.currentThread().interrupted()){
				System.out.println(this + "interrupted");
				return;
			}
			System.out.println(Thread.currentThread().getName());
			id--;
		}
		
	}
}


public class Ex20 {
	
	
	public static void main(String[] args) {
		
	
	ExecutorService exe = Executors.newCachedThreadPool();
	
	for(int i=0;i<5;i++){
		exe.execute(new InterruptedTask());
	}
	
	 List<Runnable> runTask = exe.shutdownNow();
	 
	 System.out.println(runTask);
	 
 	}
	
	

}
