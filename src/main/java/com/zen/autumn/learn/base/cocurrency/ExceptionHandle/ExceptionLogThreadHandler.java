package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

public class ExceptionLogThreadHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
			
		System.err.println("catch exception of thread " + t.getName());
	}

}
