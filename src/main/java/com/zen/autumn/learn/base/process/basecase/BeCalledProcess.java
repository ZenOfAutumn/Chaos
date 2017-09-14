package com.zen.autumn.learn.base.process.basecase;

import java.io.FileOutputStream;
import java.io.IOException;

public class BeCalledProcess {

	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream io  = new FileOutputStream("C:/Users/wuliang07/Desktop/1.txt");
	
		io.close();
		System.out.println("test");
	}
}
