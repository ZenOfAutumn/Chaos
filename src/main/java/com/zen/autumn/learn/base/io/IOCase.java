package com.zen.autumn.learn.base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOCase {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DataInputStream in = new DataInputStream(
				new ByteArrayInputStream(new BufferedReader(new FileReader("")).readLine().getBytes()));
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("")));
		writer.println("");
		

	}
}
