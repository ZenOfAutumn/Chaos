package com.zen.autumn.learn.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOTest {
	
	
	public static void main(String[] args) throws IOException {
	
		  BufferedWriter matchWriter = new BufferedWriter(new OutputStreamWriter(
         new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\11.txt")), "utf-8"));
        
         matchWriter.write("11");
        
         matchWriter.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("‪C:\\Users\\Administrator\\Desktop\\11.txt"), "utf-8"));

        while (true) {
            System.out.println(reader.readLine());
        }
		
	}

}
