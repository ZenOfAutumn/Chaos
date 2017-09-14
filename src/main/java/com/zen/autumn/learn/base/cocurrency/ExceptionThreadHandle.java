package com.zen.autumn.learn.base.cocurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionTask implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getUncaughtExceptionHandler());
		throw new RuntimeException();
		
	}
	
}

class HandleThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
	System.out.println(this+"creating new thread");
	Thread t=  new Thread(r);
	System.out.println(t+"created");
	t.setUncaughtExceptionHandler(new ExceptionThreadHandle());
	System.out.println("eh "+ t.getUncaughtExceptionHandler());
	return t;
	
	}
	
}

public class ExceptionThreadHandle implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}
	
	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionThreadHandle());
		ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(new ExceptionTask());
		exe.shutdown();
		
	}

}
