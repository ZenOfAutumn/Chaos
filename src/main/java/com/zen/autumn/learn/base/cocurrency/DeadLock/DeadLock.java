package com.zen.autumn.learn.base.cocurrency.DeadLock;

class TaskLeft implements Runnable{
	
	private DeadLock deadLock;
	
	public TaskLeft(final DeadLock deadLock) {
		this.deadLock = deadLock;
	
	}
	
	@Override
	public void run() {
		try{
			
			deadLock.leftRight();
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		
	}
}

class TaskRight implements Runnable{
	
	private DeadLock deadLock;
	
	public TaskRight(final DeadLock deadLock) {
		this.deadLock = deadLock;
	
	}
	
	@Override
	public void run() {
		try{
			
			deadLock.rightLeft();
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		
	}
}


public class DeadLock {

	
	private final Object left = new Object();
	
	private final Object right = new Object();
	
	public void leftRight() throws Exception{
		
		synchronized (left) {
			Thread.sleep(2000);
			synchronized (right) {
				System.out.println("leftRight end");
			}
		}
	}
	
	public void rightLeft() throws Exception{
		
		synchronized (right) {
			
			Thread.sleep(20000);
			synchronized (left) {
				System.out.println("rightLeft end");
			}			
		}
	}
	
	public static void main(String[] args) {
		
		DeadLock deadLock = new DeadLock();
		
		Thread t1 = new Thread(new TaskLeft(deadLock));
		Thread t2 = new Thread(new TaskRight(deadLock));
		
		t1.start();
		t2.start();
		
		
		
	}
	
	
}
