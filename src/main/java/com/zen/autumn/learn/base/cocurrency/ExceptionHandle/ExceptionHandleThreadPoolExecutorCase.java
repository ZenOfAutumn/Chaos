package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ExceptionHandleThreadPoolExecutorCase {
	
	public static void main(String[] args) {
		ExecutorService exe = new ExceptionHandleThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS,  new LinkedBlockingQueue<Runnable>());
		exe.submit(new ExceptionCallableTask());
		exe.shutdown();
		
	}

}
