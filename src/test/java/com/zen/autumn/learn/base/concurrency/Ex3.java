package com.zen.autumn.learn.base.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskPool implements Runnable {
	
	private static int taskCount;
	private final int id = taskCount++;

	public TaskPool() {
		System.out.println("construct" + id);

	}

	@Override
	public void run() {

		int i = 3;
		while (i > 0) {
			System.out.println("in" + id + ":" + i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i--;
		}
		System.out.println(Thread.currentThread().getName()+ " end" + id + ":" + i);

	}

}
public class Ex3 {

	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i =0;i<5;i++){
			exe.execute(new TaskPool());
		}
		exe.shutdown();
		TimeUnit.MILLISECONDS.sleep(10000);
		System.out.println("cached Tread Pool End");
		
		ExecutorService fixedExe = Executors.newFixedThreadPool(3);
		for(int i =0;i<5;i++){
			fixedExe.execute(new TaskPool());
		}
		fixedExe.shutdown();
		TimeUnit.MILLISECONDS.sleep(10000);

		System.out.println("fixed Tread Pool End");
		
		ExecutorService singleExe = Executors.newSingleThreadExecutor();
		for(int i =0;i<5;i++){
			singleExe.execute(new TaskPool());
		}
		singleExe.shutdown();
		TimeUnit.MILLISECONDS.sleep(10000);

		System.out.println("single Tread Pool End");
		
		
	}
}
