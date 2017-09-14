package com.zen.autumn.learn.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NonBlockingIO {

	static final int CLIENT_PORT = 1089;
	static final int SERVER_PORT = 8080;

	public static void main(String[] args) throws IOException {

		SocketChannel sch = SocketChannel.open();
		Selector sel = Selector.open();
		try {
			sch.socket().bind(new InetSocketAddress(CLIENT_PORT));
			sch.configureBlocking(false);
			sch.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
			sel.select();
			Iterator it = sel.selectedKeys().iterator();
			while (it.hasNext()) {

				SelectionKey selKey = (SelectionKey) it.next();
				it.remove();
				if (selKey.isConnectable()) {

					InetAddress ad = InetAddress.getLocalHost();
					System.out.println("Connect will not block");

					if (!sch.connect(new InetSocketAddress(ad, SERVER_PORT)))
						sch.finishConnect();
				}
				if (selKey.isReadable())
					System.out.println("Read will not block");
				// Is underlying channel of key ready to write?
				// if((key.readyOps() & SelectionKey.OP_WRITE) != 0)
				if (selKey.isWritable())
					System.out.println("Write will not block");
			}
		} finally {
			sch.close();
			sel.close();
		}
	}
}