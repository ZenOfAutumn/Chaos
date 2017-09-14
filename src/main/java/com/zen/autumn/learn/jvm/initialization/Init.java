package com.zen.autumn.learn.jvm.initialization;

interface I1 {
	int i = 0;
	static int j = 1;
}

class C1 {
	public int i = 0;
	public static int j = 1;
	static {
		int k = 2;
		j = k;
	}

}

public class Init {
	
	static int i=0;
	
	int j = 0;
	
	
	

}
