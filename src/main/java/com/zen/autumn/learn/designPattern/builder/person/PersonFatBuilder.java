package com.zen.autumn.learn.designPattern.builder.person;

public class PersonFatBuilder extends PersonBuilder{
	
	public PersonFatBuilder(Graphics g, Pen p) {
		super(g, p);
	}

	@Override
	public void BuildHead() {
		System.out.println("fat build head");
	}

	@Override
	public void BuildBody() {
		System.out.println("fat build body");		
		
	}

	@Override
	public void BuildArm() {
		System.out.println("fat build arm");
				
	}

	@Override
	public void BuildLeg() {
		System.out.println("fat build leg");
		
	}

}
