package com.zen.autumn.learn;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

	static final int SIZE = 1024;
	
	
	
	
	public static void main(String[] args) throws Exception {
		
//		FileChannel fc = new FileOutputStream("Data.txt").getChannel();
//		fc.write(ByteBuffer.wrap("Some text".getBytes()));
//		fc.close();
//		
//		fc = new RandomAccessFile("Data.txt", "rw").getChannel();
//		fc.position(fc.size());
//		fc.write(ByteBuffer.wrap("Some more".getBytes()));
//		fc.close();
		
		FileChannel fc = new FileInputStream("C:/Users/wuliang07/Desktop/Data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(SIZE);
		fc.read(buff);
		buff.flip();
		
		while(buff.hasRemaining()){
			System.out.println((char)buff.get());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
