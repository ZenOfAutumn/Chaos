package com.zen.autumn.learn.base.generics;

import java.util.Date;

interface TimeStamped{long getStamp();}

class TimeStampedImpl implements TimeStamped{

	private final long timeStamp;
	
	public TimeStampedImpl() {
		timeStamp = new Date().getTime();
	}
	
	@Override
	public long getStamp() {
		return timeStamp;
	}
	
}

interface SerialNumbered{
	long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered{
	
	private static long counter = 1;
	
	private final long SerialNumber = counter++;

	@Override
	public long getSerialNumber() {
		return SerialNumber;
	}
}

interface Basic{
	public void set(String val);
	public String get();
}

class BasicImpl implements Basic{

	private String value;
	
	@Override
	public void set(String val) {
		value = val;
		
	}

	@Override
	public String get() {
		return value;
	}
}

class Mixin extends BasicImpl implements TimeStamped,SerialNumbered{

	private TimeStamped timeStamped = new TimeStampedImpl();

	private SerialNumbered serialNumbered = new SerialNumberedImp();	
	
	@Override
	public long getSerialNumber() {
		return serialNumbered.getSerialNumber();
	}

	@Override
	public long getStamp() {
		return timeStamped.getStamp();
	}	
}


public class Mixins  {

}
