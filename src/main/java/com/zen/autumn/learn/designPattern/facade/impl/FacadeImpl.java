package com.zen.autumn.learn.designPattern.facade.impl;

import com.zen.autumn.learn.designPattern.facade.subSystem.SubSystemA;
import com.zen.autumn.learn.designPattern.facade.subSystem.SubSystemB;

public class FacadeImpl {

	private static SubSystemA a;
	private static SubSystemB b;
   
	static{
	    a = new SubSystemA();
	    b= new SubSystemB();	    		
	  }

	public static void getMethod() {
		a.getMethodFromA();
		b.getMethodFromB();
	}

	public static void queryMethod() {
		a.queryMethodFromA();
		b.queryMethodFromB();

	}
	
	public static void main(String[] args){
		getMethod();
		queryMethod();
	}

}
