package com.zen.autumn.learn.designPattern.state.impl;

import com.zen.autumn.learn.designPattern.state.State;

public class GumballMachine {

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	private State state = soldOutState;

	private int count = 0;

	public GumballMachine(final int numberGumballs) {

		this.soldOutState = new SoldOutState(this);
		this.noQuarterState = new NoQuarterState(this);
		this.hasQuarterState = new HasQuarterState(this);
		this.soldState = new SoldState(this);
		this.winnerState = new WinnerState(this);
		this.count = numberGumballs;
		if (numberGumballs > 0) {
			this.state = noQuarterState;
		}
	}

	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		if (state.turnCrank()) {
			state.dispense();
		}
	}

	void setState(State state) {
		this.state = state;
	}

	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public State getState() {
		return state;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "GumballMachine [soldOutState=" + soldOutState + ", noQuarterState=" + noQuarterState
				+ ", hasQuarterState=" + hasQuarterState + ", soldState=" + soldState + ", winnerState=" + winnerState
				+ ", state=" + state + ", count=" + count + "]";
	}

}
