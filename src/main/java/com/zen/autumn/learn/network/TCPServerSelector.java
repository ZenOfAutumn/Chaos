package com.zen.autumn.learn.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class TCPServerSelector {
	
	private static final int BUFSIZE = 256;
	
	private static final int TIMEOUT = 3000;
	
	public static void main(String[] args) throws IOException {
		
		Selector selector = Selector.open();
		
		ServerSocketChannel ssl  =ServerSocketChannel.open();
		ssl.socket().bind(new InetSocketAddress(8080));
		ssl.configureBlocking(false);
		ssl.register(selector, SelectionKey.OP_ACCEPT);
		
		TCPProtocol protocol = new EchoSelectorProtocol();
		
		while(true){
			
			if(selector.select(TIMEOUT) ==0){
				System.out.println(".");
				continue;
			}
			
			Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
			
			while(keyIter.hasNext()){
				
				SelectionKey selkey = keyIter.next();
				
				if(selkey.isAcceptable()){
					protocol.handleAccept(selkey);
				}
				
				if(selkey.isReadable()){
					protocol.handleRead(selkey);
				}
				
				if(selkey.isValid() && selkey.isWritable()){
					protocol.handleWrite(selkey);
				}
				
				keyIter.remove();
			}
			
			
			
			
			
			
		}
		
		
		
		
		
	}

}
