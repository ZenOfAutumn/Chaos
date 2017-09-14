package com.zen.autumn.learn.base.enums;

public enum SecurityCategory {

	STOCK();
	
	interface Security{
		enum Stock implements Security{SHORT,LONG,MARGIN}
		enum Bond implements Security{MUNICIPAL,JUNK}
	}
	
	
	
	
}
