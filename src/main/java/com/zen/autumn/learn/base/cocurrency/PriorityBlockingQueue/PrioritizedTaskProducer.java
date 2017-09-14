package com.zen.autumn.learn.base.cocurrency.PriorityBlockingQueue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTaskProducer implements Runnable {

	Random rand = new Random(47);
	private Queue<Runnable> queue;
	private ExecutorService exe;

	public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService exe2) {
		this.queue = queue;
		this.exe = exe2;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			queue.add(new PrioritizedTask(rand.nextInt(10)));
			Thread.yield();
		}
		
		try {
			for (int i = 0; i < 10; i++) {
				TimeUnit.MILLISECONDS.sleep(250);
				queue.add(new PrioritizedTask(10));
			}

			for (int i = 0; i < 10; i++) {
				queue.add(new PrioritizedTask(i));
			}
			queue.add(new PrioritizedTask.EndSentinel(exe));
		} catch (InterruptedException e) {

		}
		System.out.println("Finished Task Produce"+	 queue.size());

	}

}
