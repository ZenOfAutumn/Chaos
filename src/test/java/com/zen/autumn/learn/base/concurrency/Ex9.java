package com.zen.autumn.learn.base.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class PriorityThreadFactory implements ThreadFactory {

	private final int priority;

	public PriorityThreadFactory(int newPriority) {
		this.priority = newPriority;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(priority);
		return t;
	}

}

class SimplePriorities implements Runnable {
	private int countDown = 5;
	
	private volatile double d; // No optimization

	public SimplePriorities() {
	}

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	public void run() {
		while (true) {
			// An expensive, interruptable operation:
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

}

public class Ex9 {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));

		for (int i = 0; i < 5; i++) {
			exe.execute(new SimplePriorities());
		}

		exe.shutdown();

		ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));

		for (int i = 0; i < 5; i++) {
			exec.execute(new SimplePriorities());
		}

		exec.shutdown();

	}
}
