package com.zen.autumn.learn.base.enums;

public interface Food {
	
	enum Appetizer implements Food{
		SALAD;		
	}
	enum MainCourse implements Food{
		LASAGNE;
	}	
	enum Coffee implements Food{
		LATTE;
	}
	
	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
	}

}
