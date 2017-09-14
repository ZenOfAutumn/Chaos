package com.zen.autumn.learn.base.enums;

public enum Course {
	
	APPETIZER(Food.Appetizer.class),
	
	MAINCOURSE(Food.MainCourse.class),
	
	COFFEE(Food.Coffee.class);
	
	private Food[] values;
	
	Course(Class<? extends Food> clazz){
		this.values = clazz.getEnumConstants();
	}
}
