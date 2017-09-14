package com.zen.autumn.learn.designPattern.singleton;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.collect.Lists;

public class CocurrencySingleton {

	private static volatile CocurrencySingleton instance;
	
	private static Lock lock = new ReentrantLock();

	private CocurrencySingleton() {
	}

	public static CocurrencySingleton getInstance() {
		if (instance == null) {
			try{
				lock.tryLock();
				if (instance == null) {
					instance = new CocurrencySingleton();
				}
			}finally{
				lock.unlock();
			}			
		}
		return instance;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe = Executors.newCachedThreadPool();
		List<Future<CocurrencySingleton>> results = Lists.newArrayList();		
		
		for(int i =0;i<100;i++){
			results.add(exe.submit(new Callable<CocurrencySingleton>() {
				@Override
				public CocurrencySingleton call() throws Exception {
					return CocurrencySingleton.getInstance();
				}
		
			}));
		}
		TimeUnit.MILLISECONDS.sleep(200);
		
		CocurrencySingleton y = results.get(0).get();
		
		for(Future<CocurrencySingleton> yy:results){
			System.out.println(y==yy.get());
		}
		exe.shutdown();
		
	}

}
