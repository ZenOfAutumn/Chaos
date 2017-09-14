package com.zen.autumn.learn.base.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	public static void main(String[] args) throws IOException {
		
		String file = "Data.txt";
	
	DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

	output.writeDouble(3.1415926);
	output.writeUTF("That was pi");
	output.writeDouble(3.1415926);
	output.writeUTF("qqqq");

	output.close();
	
	
	DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
	
	System.out.println(input.readDouble());
	System.out.println(input.readUTF());
	System.out.println(input.readDouble());
	System.out.println(input.readUTF());
	
	
	
	}
}
