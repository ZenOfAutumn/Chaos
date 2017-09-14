package com.zen.autumn.learn.base.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketTest {
	
	static final String HOST = "www.rbi.org.in";
	static final int PORT = 80;
	static final int TIMEOUT = 10000;
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
	
	
		Socket socket = new Socket();
		try{
		socket.connect(new InetSocketAddress(HOST, PORT), TIMEOUT);
		}catch(SocketTimeoutException e){
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(socket.getInputStream());
		while(scanner.hasNextLine()){
			System.out.println(scanner.nextLine());
		}
		

		try (Socket s = new Socket(HOST, PORT)) {
			InputStream in = s.getInputStream();
			Scanner scannerA = new Scanner(in);
			while (scannerA.hasNextLine()) {
				System.out.println(scannerA.nextLine());
			}

		}
	}

}
