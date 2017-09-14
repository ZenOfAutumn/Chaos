package com.zen.autumn.learn;

import java.util.concurrent.TimeUnit;

class MyThread implements Runnable {
	private int ticket = 10;

	public void run() {
		for (int i = 0; i < 20; i++) {
			if (this.ticket > 0) {
				System.out.println("卖票：ticket " + Thread.currentThread().getName() +" "+this.ticket--);
			}
		}
	}
}

public class RunnableTicket {
	
	public static void main(String[] args) {
	
		
		Thread tt = new Thread(new Runnable() {
			
			
			public void run() {
				while(true){
				System.out.println(Thread.currentThread().getName() + " 111");
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		
		
		tt.start();
		tt.start();
		
		Thread t = new Thread(){
			
		};
		
	}
};