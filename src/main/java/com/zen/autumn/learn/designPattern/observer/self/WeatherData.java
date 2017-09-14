package com.zen.autumn.learn.designPattern.observer.self;

import java.util.ArrayList;

import com.google.common.collect.Lists;

public class WeatherData implements Subject {
	
	private ArrayList observers;
	
	private float temperature;
	
	private float humidity;
	
	private float pressure;
	
	public WeatherData() {
		observers = Lists.newArrayList();
				
	}
	
	

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0){
			observers.remove(i);
		}
		
	}

	@Override
	public void notifyObservers() {
		for(Object o:observers){
			Observer ob = (Observer)o;
			ob.update(temperature, humidity, pressure);
		}

	}
	
	public  void measurementsChanged(){
		notifyObservers();
	}

	
	public void setMeasurements(float temp,float hum,float pre){
		this.temperature = temp;
		this.humidity =hum;
		this.pressure = pre;
		measurementsChanged();	
	}
	
	
}
