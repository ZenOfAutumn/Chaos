package com.zen.autumn.learn.base.enums;

import java.util.EnumSet;

enum Alphaphat{
	A,B,C;
}

public class EnumSetUseCase {

	public static void main(String[] args) {
		EnumSet<Alphaphat> al = EnumSet.allOf(Alphaphat.class);
		System.out.println(al);
		
		
	}
	
}
