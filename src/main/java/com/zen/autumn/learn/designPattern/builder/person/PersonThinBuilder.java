package com.zen.autumn.learn.designPattern.builder.person;

public class PersonThinBuilder extends PersonBuilder {
	
	

	public PersonThinBuilder(Graphics g, Pen p) {
		super(g, p);
	}

	@Override
	public void BuildHead() {
		System.out.println("thin build head");
	}

	@Override
	public void BuildBody() {
		System.out.println("thin build body");		
		
	}

	@Override
	public void BuildArm() {
		System.out.println("thin build arm");
				
	}

	@Override
	public void BuildLeg() {
		System.out.println("thin build leg");
		
	}

	
}
