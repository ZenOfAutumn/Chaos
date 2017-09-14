package com.zen.autumn.learn.designPattern.observer.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.zen.autumn.learn.designPattern.observer.self.DisplayElement;

public class CurrentConditionDisplay implements Observer, DisplayElement {

	List<Observable> observable ;

	private float temp;

	private float hum;	
	
	private String name;

	public CurrentConditionDisplay() {
		this.observable = new ArrayList<Observable>();
		// TODO Auto-generated constructor stub

	}
	
	
	public void addSubject(Observable o){
		observable.add(o);
	}

	@Override
	public void display() {
		System.out.println("temp: " + temp + " hum: " + hum + " name: "+ name);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			this.temp = weatherData.getTemp();
			this.hum = weatherData.getHum();
			display();
		}
		
		if(o instanceof New){
			New n = (New)o;
			this.name = n.getNews();
			display();
			
		}

		

	}

}
