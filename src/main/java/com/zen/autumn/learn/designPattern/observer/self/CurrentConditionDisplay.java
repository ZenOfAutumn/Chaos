package com.zen.autumn.learn.designPattern.observer.self;


public class CurrentConditionDisplay implements Observer, DisplayElement {

	private float temp;
	
	private float hum;
	
	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject weatherData){
		this.weatherData =weatherData;
		this.weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("temp: "+temp+" humi: "+hum);
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp=temp;
		this.hum = humidity;
		display();		// TODO Auto-generated method stub

	}
	
	
	
	

}
