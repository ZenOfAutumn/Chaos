package com.zen.autumn.learn.base.cocurrency.Exchanger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.zen.autumn.learn.base.cocurrency.Semaphore.Fat;

public class ExchangerDemo {
	
	
	static final int SIZE = 10;
	
	static int delay = 5;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exe = Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc  = new Exchanger<List<Fat>>();
		
		List<Fat> producerList = new CopyOnWriteArrayList<Fat>();
		List<Fat> consumerList = new CopyOnWriteArrayList<Fat>();
		
		exe.execute(new ExchangerProducer(xc,BasicGenerator.create(Fat.class),producerList));
		exe.execute(new ExchangerConsumer(xc, consumerList));
		
		TimeUnit.SECONDS.sleep(delay);
		exe.shutdownNow();	
		
		
		
	}

}
