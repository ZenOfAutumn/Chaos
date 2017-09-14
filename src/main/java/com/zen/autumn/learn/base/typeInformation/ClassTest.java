package com.zen.autumn.learn.base.typeInformation;

class Candy{
	static{
		System.out.println("loading candy");
	}
}

class Gum{
	static{
		System.out.println("loading gum");
	}
}

class Cookie{
	static{
		System.out.println("loading Cookie");
	}
}


class Building{}
class House extends Building{}

class Room extends House{}

class Big extends Building{}
class Nothing{}


public class ClassTest {
	
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		
		System.out.println(Big.class.isAssignableFrom(Building.class));
		System.out.println(Building.class.isAssignableFrom(Big.class));
		System.out.println(Big.class.isAssignableFrom(House.class));
		System.out.println(Big.class.isAssignableFrom(Room.class));
		
	
		
	}

}
