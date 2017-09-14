package com.zen.autumn.learn.base.concurrency;

import java.util.concurrent.Callable;

class SelfFibonacciSum{
	private int count = 0;
	private int n;
	private Callable<Integer> c;

	public SelfFibonacciSum(int n) {
		this.n = n;
	}

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	
	public Integer runTask() throws Exception {
		this.c = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				System.out.println(Thread.currentThread());
				int sum = 0;
				for (int i = 0; i < n; i++) {
					sum += next();
				}
				return sum;
			}
			
		};
		return c.call();		
	}

}

public class Ex10 {
	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
			System.out.println(new SelfFibonacciSum(i).runTask());
		}
	}

}
