package com.zen.autumn.learn.concurrency;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

	static void fairQueue() {

		SynchronousQueue<Integer> sq = new SynchronousQueue<Integer>(true);

		for (int i = 0; i < 10; i++) {
			final int j = i;
			Thread put = new Thread() {
				@Override
				public void run() {
					System.out.println("put thread: " + Thread.currentThread().getName() + " " + j);
					try {
						sq.put(j);
					} catch (InterruptedException e) {

					}
				}
			};
			put.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 10; i++) {
			Thread take = new Thread() {
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + " " + sq.take());
					} catch (InterruptedException e) {

					}
				}
			};
			take.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		fairQueue();
		nonFairQueue();

	}

	static void nonFairQueue() {

		SynchronousQueue<Integer> sq = new SynchronousQueue<Integer>(false);

		for (int i = 0; i < 10; i++) {
			final int j = i;
			Thread put = new Thread() {
				@Override
				public void run() {
					System.out.println("put thread: " + Thread.currentThread().getName() + " " + j);
					try {
						sq.put(j);
					} catch (InterruptedException e) {

					}
				}
			};
			put.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		for (int i = 0; i < 10; i++) {
			Thread take = new Thread() {
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + " " + sq.take());
					} catch (InterruptedException e) {

					}
				}
			};
			take.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
