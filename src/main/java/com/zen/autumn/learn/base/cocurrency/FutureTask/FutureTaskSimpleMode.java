package com.zen.autumn.learn.base.cocurrency.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskSimpleMode {
	
	private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object,Future<String>>();
	
	
	private String executeTask(final String taskName) throws InterruptedException, ExecutionException{
		
		while(true){
			Future<String> future = taskCache.get(taskName);
			if(future == null){
				Callable<String> task = new Callable<String>() {
					@Override
					public String call() throws Exception {
						return taskName;
					}
					
				};
				
				FutureTask<String> futureTask = new FutureTask<String>(task);
				
				future = taskCache.putIfAbsent(taskName, futureTask);
				
				if(future == null){
					future = futureTask;
					futureTask.run();
					
				}
				
				
			}
			
			try{
				return future.get();
			}catch(CancellationException e){
				taskCache.remove(taskName, future);
			}
			
			
		}
		
		
		
		
	}
	

}
