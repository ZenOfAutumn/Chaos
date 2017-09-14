package com.zen.autumn.learn.designPattern.singleton;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

public class SychronizedSingleton {

	private static volatile SychronizedSingleton instance;

	private SychronizedSingleton() {
	}

	public static SychronizedSingleton getInstance() {
		if (instance == null) {
			synchronized (SychronizedSingleton.class) {
				if (instance == null) {
					instance = new SychronizedSingleton();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe = Executors.newCachedThreadPool();
		
		List<Future<SychronizedSingleton>> results = Lists.newArrayList();

		for (int i = 0; i < 100; i++) {
			results.add(exe.submit(new Callable<SychronizedSingleton>() {
				@Override
				public SychronizedSingleton call() throws Exception {
					return SychronizedSingleton.getInstance();
				}

			}));
		}
		TimeUnit.MILLISECONDS.sleep(200);

		SychronizedSingleton y = results.get(0).get();

		for (Future<SychronizedSingleton> yy : results) {
			System.out.println(y == yy.get());
		}
		exe.shutdown();

	}

}
