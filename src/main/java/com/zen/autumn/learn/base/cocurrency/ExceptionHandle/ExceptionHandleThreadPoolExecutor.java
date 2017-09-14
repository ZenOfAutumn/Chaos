package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExceptionHandleThreadPoolExecutor extends ThreadPoolExecutor {

	public ExceptionHandleThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
	}
		
	@Override
	protected void afterExecute(Runnable r, Throwable t) {		
		t.printStackTrace();
	}

}
