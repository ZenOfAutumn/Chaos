package com.zen.autumn.learn.base.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AnotherTimerTask implements Runnable{
	
	private Timer timer = new Timer();
	private int delay;
	
	public AnotherTimerTask(int delay) {
		this.delay =delay;
	}
	
	@Override
	public void run() {
		timer.schedule(new TimerTask() {			
			@Override
			public void run() {
				System.out.println("end");
			}
		}, delay);		
		System.out.println(Thread.currentThread() + "running");
		
	}
	
}

public class Ex14 {

	public static void main(String[] args) {

		ExecutorService exe = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			exe.execute(new AnotherTimerTask(i * 1000));
		}
	}
}
