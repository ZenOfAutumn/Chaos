package com.zen.autumn.learn.jvm.applet;

public class VolatileTest {

	public static volatile int race = 0;

	public static synchronized void safeInc(){
		race++;
	}
	
	
	public static  void increase() {
		race++;
	}

	static final int THREADS_COUNT = 20;

	public static void main(String[] args) {

		Thread[] tg = new Thread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++) {
			tg[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						increase();
					}
				}
			});
			tg[i].start();
		}

		while (Thread.activeCount() > 1)
			Thread.yield();
		System.out.println(race);

	}

}
