package com.zen.autumn.learn.base.cocurrency;

import java.util.concurrent.TimeUnit;

public class DeamonUseCase implements Runnable {

	@Override
	public void run() {
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+ this);
			}
		}catch(InterruptedException e){
			System.out.println("sleep() Interupted");
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0;i<10;i++){
			Thread deamon = new Thread(new DeamonUseCase());
			deamon.setDaemon(true);
			deamon.start();
		}
		System.out.println("all deamon start");
		TimeUnit.MILLISECONDS.sleep(175);
		
	}

	
	
}
