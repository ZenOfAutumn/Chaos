package com.zen.autumn.learn.base.cocurrency.Interrupt;

import java.util.concurrent.TimeUnit;

class NeedsCleanUp{
	
	
	private final int id;
	
	public NeedsCleanUp(int id) {
		this.id = id;
		System.err.println("needs clean up: " + id);
	}
	
	public void cleanUp() {
		System.err.println("clean up: " + id);
	}
	
}


class Blocked3 implements Runnable {

	private volatile double d = 0.0;

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				NeedsCleanUp n1 = new NeedsCleanUp(1);
				try {
					System.err.println("sleep");
					TimeUnit.SECONDS.sleep(10);
					NeedsCleanUp n2 = new NeedsCleanUp(2);

					try {
						System.err.println("cal");
						for (int i = 1; i < 250000; i++) {

						}
						System.err.println("finish");
					} finally {
						n2.cleanUp();
					}

				} finally {
					n1.cleanUp();
				}

			}
			System.err.println("exist via while() test");
		} catch (InterruptedException e) {
			System.err.println("exist via interrupt exception");
		}

	}

}


public class InterruptingIdiom {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Thread t = new Thread(new Blocked3());
		t.start();
		TimeUnit.SECONDS.sleep(9);
		t.interrupt();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
