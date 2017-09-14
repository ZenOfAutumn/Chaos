package com.zen.autumn.learn.base.concurrency;

class Task implements Runnable {
	
	private static int taskCount;
	private final int id = taskCount++;

	public Task() {
		System.out.println("construct" + id);

	}

	@Override
	public void run() {

		int i = 3;
		while (i > 0) {
			System.out.println("in" + id + ":" + i);
			Thread.yield();
			i--;
		}
		System.out.println("end" + id + ":" + i);

	}

}

public class Ex1 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Task()).start();
		}
	}

}
