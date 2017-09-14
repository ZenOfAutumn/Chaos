package com.zen.autumn.learn.base.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvailableCharSets {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		MappedByteBuffer out = new RandomAccessFile("", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0,
				0x8FFFFF);

		System.out.println(System.getProperty("file.encoding"));

		SortedMap<String, Charset> charSets = Charset.availableCharsets();

		Iterator<String> it = charSets.keySet().iterator();

		while (it.hasNext()) {
			String csName = it.next();
			System.out.println(csName);
			Iterator aliases = charSets.get(csName).aliases().iterator();
			while(aliases.hasNext()){
				System.out.print(aliases.next()+" ");
			}
			System.out.println();
			
			
			
		}
		
		
		
		
	}
	
}
