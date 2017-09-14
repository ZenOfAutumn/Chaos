package com.zen.autumn.learn.designPattern.state;

public abstract class State {
	
	public void insertQuarter(){
		
		System.out.println("please wait to insert another quarter.");
	}
	public void ejectQuarter(){
		System.out.println("There is no quarter inside.");

	}
	public boolean turnCrank(){
		System.out.println("turn twice the crank doesn't give you another gumball.");
		return false;
	}
	public void dispense(){
		System.out.println("you should first insert one quarter.");
	}
	

}
