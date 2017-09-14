package com.zen.autumn.learn.base.socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class WhoAmI {

	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getByName("2456BBAB8B85B37");
		System.out.println(address);
		InetAddress local = InetAddress.getByName(null);
		System.out.println(local);

	}
}
