package com.zen.autumn.learn.base.cocurrency.Sychronized;

public class SynchronizedBlockClass {
	
	private Object syncObject;
	
	public void f() throws InterruptedException{
		
		Thread.sleep(1000);
		synchronized (syncObject) {
			
		}
		return;
		
	}

}
