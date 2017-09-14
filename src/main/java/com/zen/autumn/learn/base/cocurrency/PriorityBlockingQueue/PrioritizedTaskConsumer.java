package com.zen.autumn.learn.base.cocurrency.PriorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PrioritizedTaskConsumer implements Runnable {

	private PriorityBlockingQueue<Runnable> q;

	public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
		this.q = q;
	}

	@Override
	public void run() {

		try {
			System.out.println(q.size());
			while (!Thread.interrupted()) {
				q.take().run();
			}
		} catch (InterruptedException e) {

		}
		System.out.println("Finished PrioritizedTaskConsumer");

	}
}
