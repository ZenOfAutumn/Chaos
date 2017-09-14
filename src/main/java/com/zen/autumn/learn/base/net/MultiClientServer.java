package com.zen.autumn.learn.base.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


class ThreadEchoHandler implements Runnable{
	
	private Socket incoming;
	
	public ThreadEchoHandler(Socket incoming) {
		this.incoming = incoming;
	}
	
	@Override
	public void run() {
		try{
			try{
				InputStream input = incoming.getInputStream();
				OutputStream output = incoming.getOutputStream();				
				Scanner scanner = new Scanner(input);
				PrintWriter writer = new PrintWriter(output,true);
				writer.println("Hello,Enter BYE to exit");
				boolean done = false;
				while(!done && scanner.hasNextLine()){
					String line = scanner.nextLine();
					writer.println("Echo:"+line);
					System.out.println(line);
					if(line.trim().equals("BYE")){
						done = true;
					}
				}	
			}finally{
				incoming.close();
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}	
		
	}
}


public class MultiClientServer {
	
	static final int PORT = 8189;
	
	public static void main(String[] args) {		
		
		try{
			int i= 1;
			ServerSocket s= new ServerSocket(PORT);
			while(true){
				Socket incoming = s.accept();
				System.out.println("Spawning "+i);
				Runnable runnable = new ThreadEchoHandler(incoming);
				Thread t = new Thread(runnable);
				t.start();
				i++;
			}			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
