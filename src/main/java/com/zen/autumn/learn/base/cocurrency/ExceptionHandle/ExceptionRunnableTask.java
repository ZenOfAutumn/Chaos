package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

public class ExceptionRunnableTask implements Runnable {

	@Override
	public void run() {
		throw new NullPointerException("runnable exception");		
	}

}
