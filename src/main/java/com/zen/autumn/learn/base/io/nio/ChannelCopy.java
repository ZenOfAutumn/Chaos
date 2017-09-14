package com.zen.autumn.learn.base.io.nio;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
	
	static final int SIZE = 1024;
	
	public static void main(String[] args) throws Exception{
		
		FileChannel in = new FileInputStream("ata.txt").getChannel();
		FileChannel out = new FileOutputStream("22.txt").getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(SIZE);
		
		while(in.read(buffer)!=-1){
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		
		
	}

}
