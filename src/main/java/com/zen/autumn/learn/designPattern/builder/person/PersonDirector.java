package com.zen.autumn.learn.designPattern.builder.person;

public class PersonDirector {

	private PersonBuilder pb;
	
	public PersonDirector(PersonBuilder pb) {
		this.pb = pb;
	}
	
	
	public void CreatePerson(){
		pb.BuildHead();
		pb.BuildBody();
		pb.BuildArm();
		pb.BuildLeg();	
	}
	
	public static void main(String[] args) {
		PersonDirector pd = new PersonDirector(new PersonThinBuilder(new Graphics(), new Pen()));
		pd.CreatePerson();
	}
	
}
