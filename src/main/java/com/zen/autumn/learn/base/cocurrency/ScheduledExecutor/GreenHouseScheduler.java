package com.zen.autumn.learn.base.cocurrency.ScheduledExecutor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("unused")
public class GreenHouseScheduler {

	private volatile boolean light = false;
	private volatile boolean water = false;
	private String thermostat = "Day";

	public synchronized String getThermo() {
		return thermostat;
	}

	public synchronized void setThermo(final String thermo) {
		this.thermostat = thermo;
	}

	ScheduledThreadPoolExecutor sch = new ScheduledThreadPoolExecutor(10);

	public void schedule(Runnable run, long delay) {
		sch.schedule(run, delay, TimeUnit.MILLISECONDS);
	}

	public void repeat(Runnable run, long initialDelay, long period) {
		sch.scheduleAtFixedRate(run, initialDelay, period, TimeUnit.MILLISECONDS);
	}

	class LightOn implements Runnable {
		@Override
		public void run() {
			System.out.println("turn on ....");
			light = true;
		}

	}

	class LightOff implements Runnable {
		@Override
		public void run() {
			System.out.println("turn off ....");
			light = false;
		}

	}
	
	class Terminate implements Runnable{
		@Override
		public void run() {
			System.out.println("T");		
			
		}
	}
	
	public static void main(String[] args) {
		GreenHouseScheduler sch = new GreenHouseScheduler();
		sch.schedule(sch.new LightOn(), 5000);
		sch.repeat(sch.new LightOff(), 0, 500);
	}

}
