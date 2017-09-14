package com.zen.autumn.learn.designPattern.adapter;

public class WildTrukey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("wild turkey gobble");
	}

	@Override
	public void fly() {
		System.out.println("wild fly");
	}

}
