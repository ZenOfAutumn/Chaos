package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ExceptionDefaultThreadCase {

	
	public static void main(String[] args) {
		
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionLogThreadHandler());
		ExecutorService exe = Executors.newCachedThreadPool();
		

		exe.execute(new ExceptionRunnableTask());
		// submit 无效
		
		exe.shutdown();
		
		
		
		
	}
}
