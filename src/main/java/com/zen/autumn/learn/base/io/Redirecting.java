package com.zen.autumn.learn.base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redirecting {
	
	
	public static void main(String[] args) throws IOException {
		System.err.println("1111");
		
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("Data.txt"));
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=reader.readLine()) != null){
			System.out.println(s);
		}
		out.close();
		System.setOut(console);
		
		
	}

}
