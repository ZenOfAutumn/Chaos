package com.zen.autumn.learn.concurrency;

import java.util.Arrays;

public class UnsafePublish {

	private int[] hello = new int[]{0,1};

	public int[] getHello() {
		return hello;
	}
	
	
	public static void main(String[] args) {
		UnsafePublish up = new UnsafePublish();
		int[] a = up.getHello();
		a[1 ]=2;
		System.out.println(Arrays.toString(up.getHello()));
	}
	
}
