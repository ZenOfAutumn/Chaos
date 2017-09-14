package com.zen.autumn.learn.base.cocurrency.Exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerProducer<T> implements Runnable {
	
	private Generator<T> gen;
	
	private Exchanger<List<T>> exchanger;
	
	private List<T> holder;
	
	public ExchangerProducer(Exchanger<List<T>> exchanger,Generator<T> gen,List<T> holder) {
		this.exchanger = exchanger;
		this.gen =gen;
		this.holder = holder;	
	}
	
	@Override
	public void run() {
		
		try{
			while(!Thread.interrupted()){
				for(int i = 0;i<ExchangerDemo.SIZE;i++){
					holder.add(gen.next());
				}
				holder = exchanger.exchange(holder);			
			}
		}catch(InterruptedException e){
		}
	}
	
	
	

}
