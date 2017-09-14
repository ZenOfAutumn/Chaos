package com.zen.autumn.learn.designPattern.singleton;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

public class GenericSingleton<T> {

	private static GenericSingleton<Object> instance = new GenericSingleton<Object>(); 

	private GenericSingleton() {
		
	}		
	
	@SuppressWarnings("unchecked")
	public static <T> GenericSingleton<T> getInstance() {
		return (GenericSingleton<T>) instance;
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService exe = Executors.newCachedThreadPool();	
		
		List<Future<GenericSingleton<String>>> stringResults = Lists.newArrayList();
		List<Future<GenericSingleton<Number>>> numberResults = Lists.newArrayList();

		for (int i = 0; i < 30; i++) {
			stringResults.add(exe.submit(new Callable<GenericSingleton<String>>() {
				@Override
				public GenericSingleton<String> call() throws Exception {
					return getInstance();
				}

			}));
			
			numberResults.add(exe.submit(new Callable<GenericSingleton<Number>>() {
				@Override
				public GenericSingleton<Number> call() throws Exception {
					return getInstance();
				}
			}));
			
		}
		TimeUnit.MILLISECONDS.sleep(200);

		GenericSingleton<String> y = stringResults.get(0).get();

		for (Future<GenericSingleton<String>> yy : stringResults) {
			System.out.print(y == yy.get());
		}
		System.out.println(y);
		System.out.println();

		GenericSingleton<Number> x = numberResults.get(0).get();

		for (Future<GenericSingleton<Number>> yy : numberResults) {
			System.out.print(x == yy.get());
		}
		
		System.out.println(x);
		
		exe.shutdown();
		
		
	}
	

}
