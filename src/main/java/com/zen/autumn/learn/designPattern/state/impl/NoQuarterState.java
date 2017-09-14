package com.zen.autumn.learn.designPattern.state.impl;

import com.zen.autumn.learn.designPattern.state.State;

public class NoQuarterState extends State {

	private GumballMachine machine;

	public NoQuarterState(GumballMachine machine) {
		super();
		this.machine = machine;
	}

	@Override
	public void insertQuarter() {
		machine.setState(machine.getHasQuarterState());
	}

	

}
