package com.zen.autumn.learn;

import org.apache.commons.lang3.EnumUtils;

public enum EnumUtilsTest {
	
	A,B,C;
	
	
	public static void main(String[] args) {
		System.out.println(EnumUtils.getEnumList(EnumUtilsTest.class));
		System.out.println(EnumUtils.getEnumMap(EnumUtilsTest.class));
	}

}
