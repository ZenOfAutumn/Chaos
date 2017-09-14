package com.zen.autumn.learn.designPattern.state.impl;


import com.zen.autumn.learn.designPattern.state.State;

public class SoldState extends State {
	
	private GumballMachine machine;


	public SoldState(GumballMachine machine) {
		super();
		this.machine = machine;
	}

	@Override
	public void dispense() {
		machine.releaseBall();
		if(machine.getCount()>0){
			machine.setState(machine.getNoQuarterState());
		}else{
			System.out.println("oops, out of gumball.");
			machine.setState(machine.getSoldOutState());
		}
	}

}
