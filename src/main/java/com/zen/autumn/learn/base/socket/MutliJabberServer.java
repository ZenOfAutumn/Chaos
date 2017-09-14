package com.zen.autumn.learn.base.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class SingleJabberServer extends Thread{
	
	
	private Socket socket;
	
	private BufferedReader in;
	
	private PrintWriter out;

	public SingleJabberServer(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		super.start();
	}
	
	@Override
	public void run() {

		try{
			System.out.println(socket);
			while(true){
				String str = in.readLine();
				if(str.equals("END"))break;
				System.out.println("Echoing: "+str);
				out.println(str);
			}
			System.out.println("closing............");
		}catch(IOException e){
			System.out.println("IO Exception");
		}finally {
			try{
			socket.close();
			}catch(IOException e){
				System.err.println("socket not closed");
			}
		}
	}
	
	
	
	
	
}

public class MutliJabberServer {
	
	
	static final int PORT= 8080;
	
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket s = new ServerSocket(PORT);
		
		System.out.println("server start");
		
		try{
			while(true){
				Socket socket = s.accept();
				try{
					new SingleJabberServer(socket);
				}catch(IOException e){
					socket.close();
				}
				
			}
		}finally{
			s.close();
		}
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
