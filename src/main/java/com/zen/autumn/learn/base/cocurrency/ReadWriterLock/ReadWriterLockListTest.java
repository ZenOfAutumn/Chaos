package com.zen.autumn.learn.base.cocurrency.ReadWriterLock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReadWriterLockListTest {

	ExecutorService exe = Executors.newCachedThreadPool();
	private final static int SIZE = 100;
	private static Random rand = new Random(47);

	private ReadWriterLockList<Integer> list = new ReadWriterLockList<Integer>(SIZE, 0);

	public ReadWriterLockListTest(int nReaders, int nWriters) {

		for (int i = 0; i < nReaders; i++) {
			exe.execute(new Reader());
		}
		for (int i = 0; i < nWriters; i++) {
			exe.execute(new Writer());
		}

	}

	private class Writer implements Runnable {

		@Override
		public void run() {
			try {
				for (int i = 0; i < 20; i++) {
					list.set(i, rand.nextInt());
					TimeUnit.MILLISECONDS.sleep(100);
				}
			} catch (InterruptedException e) {

			}
			System.out.println("Writer finished");
			exe.shutdownNow();
		}
	}

	private class Reader implements Runnable {

		@Override
		public void run() {

			try {
				while (!Thread.interrupted()) {
					System.out.println(Thread.currentThread().getName() + " reader");
					for (int i = 0; i < SIZE; i++) {
						list.get(i);
						TimeUnit.MILLISECONDS.sleep(1);
					}
				}
			} catch (InterruptedException e) {

			}
		}

	}
	
	public static void main(String[] args) {
		new ReadWriterLockListTest(100, 1);
	}

}
