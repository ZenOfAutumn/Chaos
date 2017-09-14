package com.zen.autumn.learn.jvm.gc;

import java.lang.ref.SoftReference;

public class GC {
	
	
	static final int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		
		int[] bigMemo = new int[2* _1MB];
		SoftReference<Object> soft = new SoftReference<Object>(bigMemo);
		bigMemo = null;
		int[] strongRef = new int[2* _1MB];
	}

}
