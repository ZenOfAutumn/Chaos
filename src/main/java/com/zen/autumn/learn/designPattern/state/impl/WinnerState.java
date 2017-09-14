package com.zen.autumn.learn.designPattern.state.impl;

import com.zen.autumn.learn.designPattern.state.State;

public class WinnerState extends State {
	

	private GumballMachine machine;


	public WinnerState(GumballMachine machine) {
		super();
		this.machine = machine;
	}


	@Override
	public void dispense() {
		machine.releaseBall();
		if(machine.getCount() == 0){
			System.out.println("no more gumball.");
			
		}else if(machine.getCount()>0){
			machine.releaseBall();
			if(machine.getCount()>0){
				machine.setState(machine.getNoQuarterState());
			}else{
				System.out.println("oops, out of gumball.");
				machine.setState(machine.getSoldOutState());
			}
		}

	}

}
