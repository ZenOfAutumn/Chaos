package com.zen.autumn.learn.base.cocurrency.Exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerConsumer<T> implements Runnable {
	private Exchanger<List<T>> exchanger;
	private List<T> holder;

	private volatile T value;

	public ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {

		this.exchanger = ex;
		this.holder = holder;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				holder = exchanger.exchange(holder);
				for (T x : holder) {
					value = x;
					holder.remove(x);
					System.out.println(x);
				}
			}
		} catch (InterruptedException e) {

		}
		System.out.println("final value " + value);

	}

}
