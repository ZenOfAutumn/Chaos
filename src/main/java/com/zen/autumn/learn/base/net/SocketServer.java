package com.zen.autumn.learn.base.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {	
	
	public static void main(String[] args) throws Exception {
		
		try(ServerSocket server = new ServerSocket(8189)){
			
			try(Socket incoming = server.accept()){
				
				InputStream in = incoming.getInputStream();
				OutputStream output = incoming.getOutputStream();
				
				try(Scanner scanner = new Scanner(in)){
					PrintWriter out = new PrintWriter(output,true);
					out.println("Hello! Enter BYE to exit.");
					boolean done = false;
					while(!done && scanner.hasNextLine()){
						String line = scanner.nextLine();
						out.println("Echo:"+line);
						System.out.println(line);
						if(line.trim().equals("BYE")){
							done = true;
						}
					}			
				}		
			}		
		}		
	}
}
