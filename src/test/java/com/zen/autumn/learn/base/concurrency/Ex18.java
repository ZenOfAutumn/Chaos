package com.zen.autumn.learn.base.concurrency;

import java.util.Timer;
import java.util.TimerTask;

class NoTask {

	void run() {
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Interrupted");
				}
			}
		}, 0, 7500);
		
		
	}
}

class RunTask implements Runnable{
	
	private NoTask notask;
	
	public RunTask(NoTask no) {
		this.notask =no;
	}
	@Override
	public void run() {
		notask.run();
	}
}

public class Ex18 {
	
	public static void main(String[] args) {
		Thread t = new Thread(new RunTask(new NoTask()));
		t.start();
		t.interrupt();
	}

}















