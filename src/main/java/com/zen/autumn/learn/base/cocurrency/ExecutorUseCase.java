package com.zen.autumn.learn.base.cocurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task implements Runnable{

	@Override
	public void run() {
		System.out.println(ThreadLocal.class.getName()+"Task run");
	}
	
}

public class ExecutorUseCase {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i= 0;i<5;i++){
			exe.execute(new Task());
		}
		exe.shutdown();
		
	}
	
}
