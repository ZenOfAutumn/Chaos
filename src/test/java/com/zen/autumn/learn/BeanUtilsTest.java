package com.zen.autumn.learn;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

class Outer {

    private String a;

    private Integer b;

    public Outer(String a, Integer b) {
        super();
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

}

class Retuo {

	private String a;

	private Integer b;

    public Retuo(String a, Integer b) {
        super();
        this.a = a;
        this.b = b;
    }

    public Retuo() {
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

}


public class BeanUtilsTest {
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		
		
		Outer outer = new Outer("a", 3);
		Outer dest = new Outer("b", 4);
		Retuo retuo = new Retuo();
		
		BeanUtils.copyProperties(retuo, outer);
		BeanUtils.copyProperties(dest, outer);

		System.err.println(dest.getA());
		System.err.println(dest.getB());
		System.err.println(retuo.getA());
		System.err.println(retuo.getB());
		 
	}
	

}
