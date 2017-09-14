package com.zen.autumn.learn.designPattern.state.impl;

import com.zen.autumn.learn.designPattern.state.State;

public class SoldOutState extends State {
	
	@SuppressWarnings("unused")
	private GumballMachine machine;	

	public SoldOutState(GumballMachine machine) {
		super();
		this.machine = machine;
	}


}
