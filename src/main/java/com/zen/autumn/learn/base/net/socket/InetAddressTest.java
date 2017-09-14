package com.zen.autumn.learn.base.net.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	static final String GOOGLE_HOST = "google.com";
	
	static final String BAIDU_HOST = "baidu.com";
	
	public static void main(String[] args) {
		
		try {
			InetAddress[] addresses = InetAddress.getAllByName(BAIDU_HOST);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
