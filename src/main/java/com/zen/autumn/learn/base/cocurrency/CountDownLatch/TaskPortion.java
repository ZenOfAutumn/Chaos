package com.zen.autumn.learn.base.cocurrency.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskPortion implements Runnable {
	
	
	private static int counter=0;
	
	private final int id = counter++;
	
	private static final Random rand = new Random(47);
	
	private final CountDownLatch latch;
	
	public TaskPortion(CountDownLatch latch) {
		this.latch = latch;
		// TODO Auto-generated constructor stub
	}
		
	
	public void doWork() throws InterruptedException{
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		System.out.println("finished");
	}
	
	
	@Override
	public String toString() {
		return String.format("%1$-3d", id);
	}
	

	@Override
	public void run() {
			try{
				doWork();
				latch.countDown();
				while (true) {
					System.err.println(Thread.currentThread().getName());
					
				}
			}catch(InterruptedException e){
				
			}		
	}

}

class WaitingTask implements Runnable{
	
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;
	
    public WaitingTask(CountDownLatch latch) {
    	this.latch = latch;
    }
	
	
	
	@Override
	public void run() {

		
		try{
			latch.await();
			System.out.println("passed for " + this);
			
		}catch(InterruptedException e){
			
		}
		
	}
	
	@Override
	public String toString() {
		return String.format("%1$-3d", id);
	}
	
	
}
















