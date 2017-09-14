package com.zen.autumn.learn.base.cocurrency.disttrbute;

public class Car {
	
	
	private final int id;
	
	private boolean engine = false;
	
	private boolean driveTrain = false;
	
	private boolean wheels = false;
	
	public Car(int id) {
		this.id = id;
	}
	
	
	public synchronized int getId(){
		return id;
	}
	
	public synchronized void addEngine(){
		engine = true;
	}
	
	public synchronized void addDrivenTrain(){
		driveTrain = true;
	}
	
	public synchronized void addWheels(){
		wheels = true;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", engine=" + engine + ", driveTrain=" + driveTrain + ", wheels=" + wheels + "]";
	}
	
	
	

}
