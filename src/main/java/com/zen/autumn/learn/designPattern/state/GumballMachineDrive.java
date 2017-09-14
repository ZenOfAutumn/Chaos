package com.zen.autumn.learn.designPattern.state;

import com.zen.autumn.learn.designPattern.state.impl.GumballMachine;

public class GumballMachineDrive {
	
	public static void main(String[] args){
		GumballMachine machine = new GumballMachine(5);
		
		System.out.println(machine);
		
		
		machine.insertQuarter();
		machine.turnCrank();
		
		System.out.println(machine);
		
		machine.insertQuarter();
		machine.turnCrank();
		machine.insertQuarter();
		machine.turnCrank();
		System.out.println(machine);

	}

}
