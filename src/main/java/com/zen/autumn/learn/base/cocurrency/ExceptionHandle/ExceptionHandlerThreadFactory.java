package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExceptionHandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new ExceptionLogThreadHandler());
		return t;
	}
	
	
	public static void main(String[] args) {
		
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionLogThreadHandler());
		ExecutorService exe = Executors.newCachedThreadPool();
		
		exe.submit(new ExceptionCallableTask());
//		exe.submit(new ExceptionRunnableTask());

		
		exe.shutdown();
	}

}
