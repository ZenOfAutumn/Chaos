package com.zen.autumn.learn.base.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class JabberClientThread extends Thread{
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private static int counter = 0;
	private int id = counter++;
	private static int threadCount = 0;
	
	public static int getThreadCount(){
		return threadCount;
	}
	
	public JabberClientThread(InetAddress addr){
		System.out.println("Making client " + id);
		threadCount++;
		try{
			socket = new Socket(addr,MutliJabberServer.PORT);
			
		}catch(IOException e){
			System.err.println("socket failed.");
		}
		
		try{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			start();
			
		}catch(IOException e) {			
			try {
			socket.close();
			} catch(IOException e2) {
			System.err.println("Socket not closed");
			}
			}		
		
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {

		try{
			for(int i = 0;i<35;i++){
				out.println("client "+ id + ":"+ i);
				String str = in.readLine();
				System.out.println(str);
			}
			Thread.currentThread().sleep(3000);
			out.println("END");
		}catch(IOException e){
			System.err.println("IOException");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				} catch(IOException e) {
				System.err.println("Socket not closed");
				}
			threadCount--; // Ending this thread
				}
		}
		
}

public class MultiJabberClient {
	
	
	static final int MAX_THREADS = 40;
	
	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		
		InetAddress addr = InetAddress.getByName(null);
		while(true){
			
			if(JabberClientThread.getThreadCount() < MAX_THREADS){
				
				new JabberClientThread(addr);
				Thread.currentThread().sleep(100);
								
			}
		}
		
		
	}
	
}
