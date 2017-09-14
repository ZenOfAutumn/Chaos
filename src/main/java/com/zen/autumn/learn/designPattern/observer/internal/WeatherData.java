package com.zen.autumn.learn.designPattern.observer.internal;

import java.util.Observable;

public class WeatherData extends Observable {
	
	private float temp;
	private float hum;
	private float press;
	
	public WeatherData() {
		// TODO Auto-generated constructor stub
	}
	
	public void measurementsChanged(){
		setChanged();
		notifyObservers();
	}
	
	public float getTemp() {
		return temp;
	}
	public float getHum() {
		return hum;
	}
	public float getPress() {
		return press;
	}
   
	
	public void setMeasureMents(float temp,float hum,float press){
		this.temp = temp;
		this.hum = hum;
		this.press = press;
		measurementsChanged();		
	}
	
	

}
