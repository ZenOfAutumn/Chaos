package com.zen.autumn.learn.base.cocurrency.Interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockMutex {

	private Lock lock = new ReentrantLock();

	public BlockMutex() {
		lock.lock();
	}

	public void f() {
		try {
			lock.lockInterruptibly();
			System.out.println("lock acquired in f()");
		} catch (InterruptedException e) {
			System.out.println("interrupted from lock acquisition in f()");
		}
	}

}

class Block2 implements Runnable {

	BlockMutex b = new BlockMutex();

	@Override
	public void run() {
		b.f();
		System.err.println("broke out of blocked call");
	}
}

public class LockInterrupt {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Block2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("interrupt");
		t.interrupt();
	}
}









