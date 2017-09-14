package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

import java.util.concurrent.Callable;

public class ExceptionCallableTask implements Callable<Integer> {

	
	@Override
	public Integer call() throws Exception {
		 throw new NullPointerException("callable exception");
	}
}
