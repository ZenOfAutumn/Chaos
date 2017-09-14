package com.zen.autumn.learn.base.cocurrency.DelayQueue;

import java.util.concurrent.DelayQueue;

public class DelayTaskConsumer implements Runnable {

	private DelayQueue<DelayedTask> q;

	public DelayTaskConsumer(DelayQueue<DelayedTask> q) {
		this.q = q;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				q.take().run();
			}
		} catch (InterruptedException e) {

		}
		System.out.println("Finished DelayedTaskConsumer");

	}

}
