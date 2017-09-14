package com.zen.autumn.learn.base.io.serialization;

import java.io.Serializable;

public class Data implements Serializable{
	
	private static final long serialVersionUID = -5012378749208639479L;
	
	private int n;
	
	public Data(int n) {
		this.n = n;
	}
	
	@Override
	public String toString() {
		return String.valueOf(n);
	}
	
	

}
