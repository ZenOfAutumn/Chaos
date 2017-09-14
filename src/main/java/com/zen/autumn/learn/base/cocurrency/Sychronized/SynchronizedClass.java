package com.zen.autumn.learn.base.cocurrency.Sychronized;

import java.util.concurrent.TimeUnit;

public class SynchronizedClass {

	public synchronized void f() throws InterruptedException {
		System.out.println("f execute");
		TimeUnit.SECONDS.sleep(10);
	}

	public synchronized void g() {
		System.out.println("g execute");
	}
}
