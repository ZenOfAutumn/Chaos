package com.zen.autumn.learn.base.cocurrency.Interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepBlocked implements Runnable{

	@Override
	public void run() {
		
		try{
			TimeUnit.SECONDS.sleep(100);
		}catch(InterruptedException e){
			System.err.println("sleep blocked InterruptedException");
		}
		
		System.err.println("Exit sleep blocked");
	}
	
	
}

class IOBlocked implements Runnable{
	
	
	private InputStream in;
	
	public IOBlocked() {
	}
	
	public IOBlocked(InputStream in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		try{
			System.err.println("waiting for read");
			in.read();
		}catch(IOException e){
			if(Thread.currentThread().isInterrupted()){
				System.err.println("interrupt by blocked I/O");
			}else{
				throw new RuntimeException(e);
			}
		}
		System.err.println("Existing IOBlocked");
		
	}
}

class SynchronizedBlocked implements Runnable{
	
	public synchronized void f(){
		while(true){
			Thread.yield();
		}
	}
	
	 public SynchronizedBlocked() {

		 new Thread(){
			 @Override
			public void run() {
				 f();
			 }
		 }.start();
	 }
	 
	 
	
	@Override
	public void run() {
		System.err.println("try to call f()");
		f();
		System.err.println("Exit syn block");
		
	}
}



public class Interrupting {
	
	
	private static ExecutorService exe = Executors.newCachedThreadPool();
	
	
	static void test(Runnable r) throws InterruptedException{
		
		Future<?> f = exe.submit(r);
		TimeUnit.SECONDS.sleep(10);
		System.err.println("Interrupting: " + r.getClass().getName());
		f.cancel(true);
		System.err.println("interrupt send to: " + r.getClass().getName());
		
	}
	
	public static void main(String[] args) throws Exception{
		
		test(new SleepBlocked());
		test(new IOBlocked());
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(300);
		System.exit(0);
		
	
		
		
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
