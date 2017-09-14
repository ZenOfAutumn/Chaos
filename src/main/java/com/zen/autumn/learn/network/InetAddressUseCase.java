package com.zen.autumn.learn.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressUseCase {
	
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress internet = InetAddress.getByName("localhost");
		System.err.println(internet.getHostAddress());
		
		
	}

}
