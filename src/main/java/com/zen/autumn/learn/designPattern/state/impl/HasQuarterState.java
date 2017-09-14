package com.zen.autumn.learn.designPattern.state.impl;

import java.util.Random;

import com.zen.autumn.learn.designPattern.state.State;

public class HasQuarterState extends State {
	
	Random random = new Random(System.currentTimeMillis());

	private GumballMachine machine;	
		
	public HasQuarterState(GumballMachine machine) {
		super();
		this.machine = machine;
	}	

	@Override
	public void ejectQuarter() {
		System.out.println("quarter returned.");
		machine.setState(machine.getNoQuarterState());		
	}

	@Override
	public boolean turnCrank() {
		System.out.println("you turned.");
		int winner = random.nextInt(10);
		if(winner ==0 && (machine.getCount()>1)){
			System.out.println("you are winner.");
			machine.setState(machine.getWinnerState());
			return true;
		}else{
			machine.setState(machine.getSoldState());
			return true;
		}		
	}
	
}
