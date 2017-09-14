package com.zen.autumn.learn.base.net;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HalfCloseSocket {
	
	static final String HOST = "time-A.timefreq.bldrdoc.gov";
	static final int PORT = 13;
	
	public static void main(String[] args) throws Exception, Exception {
		Socket socket = new Socket(HOST,PORT);
		Scanner scanner = new Scanner(socket.getInputStream());
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		writer.println("....");
		writer.flush();
		socket.shutdownOutput();
		while(scanner.hasNextLine()){
			System.out.println(scanner.nextLine());
		}
		socket.close();		
	}

}
