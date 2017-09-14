package com.zen.autumn.learn.concurrency;

public class SynchronizedClassDemo {

	static class SynchronziedClass{
		
		public static void foo(){
			synchronized (SynchronziedClass.class) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("foo");
			}
		}
		
		public static void bar(){
			synchronized (SynchronziedClass.class){
			System.out.println("bar");
			}
		}
		
		public static void clear(){
			System.out.println("clear");
		}
		
		
		public  void cur(){
			System.out.println("cur");
		}
	}
	
	static void run(){
		
		SynchronziedClass sc = new SynchronziedClass();
		
		Thread foo = new Thread(){
			@Override
			public void run() {
				while(true){
				SynchronziedClass.foo();
				}
			}
		};
		
		
		Thread bar = new Thread(){
			@Override
			public void run() {
				while(true){
				SynchronziedClass.bar();
				}
			}
		};
		
		Thread cur = new Thread(){
			@Override
			public void run() {
				while(true){
					sc.cur();
				}
			}
		};
		

		Thread clear = new Thread(){
			@Override
			public void run() {
				while(true){
					SynchronziedClass.clear();
				}
			}
		};
		
		foo.start();
		bar.start();
		cur.start();
		clear.start();
		
		
		
	}
	
	public static void main(String[] args) {
		run();
	}
	
	
	
}
