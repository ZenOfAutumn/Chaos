package com.zen.autumn.learn.collection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {
	
	
	private long time;

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(time- System.nanoTime(), TimeUnit.NANOSECONDS);
	}

}
