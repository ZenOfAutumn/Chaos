package com.zen.autumn.learn.designPattern.observer.self;

public class TestCase {
	public static void main(String[] args) {
		WeatherData data = new WeatherData();
		CurrentConditionDisplay dis = new CurrentConditionDisplay(data);
		
		data.setMeasurements(80, 65, 30.4f);
		data.setMeasurements(82, 70, 29.2f);
		data.setMeasurements(78, 90, 29.2f);
		
		
	}

}
