package com.zen.autumn.learn.base.cocurrency.disttrbute;

import java.util.concurrent.TimeUnit;

public class ChassisBuilder implements Runnable {

	private CarQueue carQueue;

	private int counter = 0;

	public ChassisBuilder(CarQueue carQueue) {
		this.carQueue = carQueue;
	}

	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {

				TimeUnit.MILLISECONDS.sleep(500);
				Car car = new Car(counter++);
				carQueue.put(car);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}