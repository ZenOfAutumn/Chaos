package com.zen.autumn.learn.network;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class EchoSelectorProtocol implements TCPProtocol {

	private int bufferSize;

	public void handleAccept(SelectionKey key) throws IOException {
		System.err.println(key.channel().getClass().getName());
		SocketChannel sch = ((ServerSocketChannel) key.channel()).accept();
		sch.configureBlocking(false);
		sch.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
	}

	public void handleRead(SelectionKey key) throws IOException {
		System.err.println(key.channel().getClass().getName());
		SocketChannel sch = (SocketChannel) key.channel();
		ByteBuffer buf = (ByteBuffer) key.attachment();
		long bytesRead = sch.read(buf);
		if (bytesRead == -1) {
			sch.close();
		} else if (bytesRead > 0) {
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		}

	}

	public void handleWrite(SelectionKey key) throws IOException {
		System.err.println(key.channel().getClass().getName());
		ByteBuffer buf = (ByteBuffer) key.attachment();
		buf.flip();
		SocketChannel sch = (SocketChannel) key.channel();
		if(!buf.hasRemaining()){
			key.interestOps(SelectionKey.OP_READ);
		}
		buf.compact();
		
	}

}
