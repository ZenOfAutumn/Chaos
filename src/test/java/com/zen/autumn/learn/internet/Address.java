package com.zen.autumn.learn.internet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Address {

	
	 private static String searchNetworkInterfaces(){
	        try {
	            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
	            while (enumeration.hasMoreElements()) {
	                NetworkInterface networkInterface = enumeration.nextElement();
	                //Ignore Loop/virtual/Non-started network interface
	                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
	                    continue;
	                }
	                Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
	                while (addressEnumeration.hasMoreElements()) {
	                    InetAddress inetAddress = addressEnumeration.nextElement();
	                    String address = inetAddress.getHostAddress();
	                    System.out.println(address);
	                }
	            }
	        } catch (SocketException e) {
	            //consider log for this exception
	        }
	        return "";
	    }
	
	public static void main(String[] args) throws UnknownHostException {
		
		searchNetworkInterfaces();
		
	}
}
