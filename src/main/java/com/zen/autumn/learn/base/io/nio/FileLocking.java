package com.zen.autumn.learn.base.io.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
	
	public static void main(String[] args) throws Exception{
		FileOutputStream out = new FileOutputStream("out.txt");
		FileLock fl = out.getChannel().tryLock();
		if(fl != null){
			System.out.println("locked file");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("release lock");
		}
		out.close();
		
	}

	

}
