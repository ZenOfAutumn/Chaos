package com.zen.autumn.learn.designPattern.observer.internal;


public class TestCase {
	public static void main(String[] args) {
		System.out.println("1111");
		WeatherData data = new WeatherData();
		New n = new New("1111");
		CurrentConditionDisplay dis = new CurrentConditionDisplay();
		dis.addSubject(data);
		dis.addSubject(n);
		
		data.setMeasureMents(80, 65, 30.4f);
		data.setMeasureMents(82, 70, 29.2f);
		data.setMeasureMents(78, 90, 29.2f);
		
		n.setNews("hello world");
		
		
	}

}
