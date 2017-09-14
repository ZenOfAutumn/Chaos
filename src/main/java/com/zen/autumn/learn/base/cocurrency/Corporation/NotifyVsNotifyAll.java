package com.zen.autumn.learn.base.cocurrency.Corporation;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Blocker{
	
	synchronized void waitingCall(){
		
		try{
			while(!Thread.currentThread().isInterrupted()){
				wait();
				System.err.println(Thread.currentThread());
			}
		}catch(InterruptedException e){
			
		}		
	}
	
	
	synchronized void prod(){notify();}
	synchronized void prodAll(){notifyAll();}
	
	
}

class Task2 implements Runnable{
	
	static Blocker b = new Blocker();
	@Override
	public void run() {
		b.waitingCall();
	}
}

class Task implements Runnable{
	
	static Blocker b = new Blocker();
	@Override
	public void run() {
		b.waitingCall();
	}
}



public class NotifyVsNotifyAll {
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService exe = Executors.newCachedThreadPool();
		
		for(int i=0;i<5;i++){
			exe.execute(new Task());
		}

		exe.execute(new Task2());
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			boolean prod = true;
			
			@Override
			public void run() {

				if(prod){
					
					System.err.println("notify");
					Task.b.prod();
					prod = false;
				}else{
					
					System.err.println("notifyall");
					Task.b.prodAll();
					prod = true;
				}
			}
		}, 400, 400);
		
		
		TimeUnit.SECONDS.sleep(5);
		timer.cancel();
		System.err.println("canceled");
		
		TimeUnit.SECONDS.sleep(5);
		System.err.println("task2 prodall");
		Task2.b.prodAll();
		TimeUnit.SECONDS.sleep(5);

		System.err.println("shut down now");
		exe.shutdown();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
