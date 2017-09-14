package com.zen.autumn.learn.base.cocurrency.PriorityBlockingQueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		Random rand = new Random(47);
		ExecutorService exe = Executors.newCachedThreadPool();
		PriorityBlockingQueue q = new PriorityBlockingQueue<Runnable>();
		exe.execute(new PrioritizedTaskProducer(q, exe));
		exe.execute(new PrioritizedTaskConsumer(q));
	}

}
