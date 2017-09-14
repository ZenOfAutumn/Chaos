package com.zen.autumn.learn.base.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class ChannelTransfer {
	
	
	public static void main(String[] args) throws IOException {
		
		FileChannel fc = new FileInputStream("ata.txt").getChannel();		
		FileChannel out = new FileOutputStream("33.txt").getChannel();
		fc.transferTo(0, fc.size(), out);	
		MappedByteBuffer buffer = fc.map(MapMode.READ_WRITE, 0, fc.size());
		
	}

}
