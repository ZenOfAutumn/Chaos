package com.zen.autumn.learn.designPattern.builder.person;

class Graphics {

}

class Pen {

}

public abstract class PersonBuilder {

	protected Graphics g;
	protected Pen p;

	public PersonBuilder(Graphics g, Pen p) {
		this.g = g;
		this.p = p;

	}
	
	public abstract void BuildHead();
	public abstract void BuildBody();
	public abstract void BuildArm();
	public abstract void BuildLeg();
	

}
