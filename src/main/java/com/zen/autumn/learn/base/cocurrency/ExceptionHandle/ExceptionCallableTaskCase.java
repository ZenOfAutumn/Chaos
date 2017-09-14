package com.zen.autumn.learn.base.cocurrency.ExceptionHandle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


// callable中的抛出的异常存储在future中
public class ExceptionCallableTaskCase {
	
	public static void main(String[] args)  {
		
		ExecutorService exe = Executors.newCachedThreadPool();
	
		Future<Integer> future = exe.submit(new ExceptionCallableTask());
		
		exe.shutdown();
		
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}	
		
		
	}

}
