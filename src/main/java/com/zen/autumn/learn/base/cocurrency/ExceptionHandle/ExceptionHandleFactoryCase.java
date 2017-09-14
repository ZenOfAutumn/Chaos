package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionHandleFactoryCase {
	
	public static void main(String[] args) {
		
		ExecutorService exe = Executors.newCachedThreadPool(new ExceptionHandlerThreadFactory());
		exe.execute(new ExceptionRunnableTask());
		exe.shutdown();
				
	}

}
