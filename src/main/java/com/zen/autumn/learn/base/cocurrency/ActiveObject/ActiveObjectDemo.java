package com.zen.autumn.learn.base.cocurrency.ActiveObject;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ActiveObjectDemo {

	private ExecutorService exe = Executors.newSingleThreadExecutor();

	private Random rand = new Random(47);

	private void pause(int factor) {
		try {
			TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(factor));
		} catch (InterruptedException e) {
			System.out.println("sleep interrupt");
		}
	}

	public Future<Integer> calculateInt(final int x, final int y) {
		return exe.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("starting" + x + " + " + y);
				pause(500);
				return x + y;
			}
		});
	}

	public Future<Float> calculateFloat(final float x, final float y) {
		return exe.submit(new Callable<Float>() {
			@Override
			public Float call() throws Exception {
				System.out.println("starting" + x + " + " + y);
				pause(2000);
				return x + y;
			}
		});
	}

	public void shutDown() {
		exe.shutdown();
	}
	
	public static void main(String[] args) {
		ActiveObjectDemo da = new ActiveObjectDemo();
		
		List<Future<?>> results = new CopyOnWriteArrayList<Future<?>>();
		
		for(float f=0.0f;f<10.f;f+=0.2f){
			results.add(da.calculateFloat(f, f));
		}
		
		for(int i=0;i<5;i++){
			results.add(da.calculateInt(i, i));
		}
		
		while(results.size()>0){
			for(Future<?> f:results){
				if(f.isDone()){
					try{
						System.out.println(f.get());
					}catch(Exception e){
						throw new RuntimeException(e);
					}
					results.remove(f);
				}			
			}
		}
			
		da.shutDown();
		
		
	}
	

}
