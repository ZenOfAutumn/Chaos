package com.zen.autumn.learn.jvm.memory;

public class MemoryCycleRelease {
	
	public static void test(){
		while(true){
			StringBuilder str = new StringBuilder();
			str = null;
		}
	}
	
	public static void main(String[] args) {
		
		test();
		
		
	}

	
	
}
