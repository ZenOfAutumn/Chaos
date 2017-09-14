package com.zen.autumn.learn.base.cocurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

class TaskWithResult implements Callable<String>{
	
	int id;
	
	public TaskWithResult(int id){
		this.id = id;
	}
	
	@Override
	public String call(){
		System.out.println(Thread.currentThread().getPriority());
		return "TaskWithResult id is: " + id;
	}
	
}

public class CallableUseCase  {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe = Executors.newCachedThreadPool();
		
		Future<String> future = exe.submit(new TaskWithResult(110));

		System.out.println("1111"+future.isDone());
		System.out.println(future.get());
		
		List<Future<String>> results = Lists.newArrayList();

		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);

		for (int i = 0; i < 10; i++) {
			results.add(exe.submit(new TaskWithResult(i)));
		}

		for (Future<String> fs : results) {
			System.out.println(fs.isDone());
			System.out.println(fs.get());
		}



		
		exe.shutdown();

	} 
}
