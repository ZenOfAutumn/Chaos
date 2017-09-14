package com.zen.autumn.learn.base.concurrency;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable {
	private Thread[] t = new Thread[10];

	public void run() {
		System.out.println("mother " + Thread.currentThread().getName());

		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started, ");
		}
		for (int i = 0; i < t.length; i++)
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
		while (true)
			Thread.yield();
	}
}

class DaemonSpawn implements Runnable {
	public void run() {
		System.out.println("son " + Thread.currentThread().getName());
		while (true)
			Thread.yield();
	}
}

public class Ex7 {
	public static void main(String[] args) throws InterruptedException {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");

		TimeUnit.SECONDS.sleep(1);
	}

}
