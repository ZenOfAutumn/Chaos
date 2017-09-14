package com.zen.autumn.learn.concurrency;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueDemo {
	static LinkedTransferQueue<Integer> ltq = new LinkedTransferQueue<Integer>();

	
	static void transfer(boolean block,long timeout,int e) throws InterruptedException{
		
		
		if(block){
			ltq.transfer(e);
		}else{
			ltq.tryTransfer(e, timeout, TimeUnit.MILLISECONDS);
		}
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				try {
					transfer(true, 0, 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				try {
					transfer(false, 0, 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		
		t1.start();
		t2.start();
		Thread.sleep(1000);
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		
	}
	
	
	
	
}
