package com.zen.autumn.learn.base.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

class ServeOneJabber implements Runnable {
	private SocketChannel channel;
	private Selector sel;

	public ServeOneJabber(SocketChannel ch) throws IOException {
		channel = ch;
		sel = Selector.open();
	}

	public void run() {
		ByteBuffer buffer = ByteBuffer.allocate(16);
		boolean read = false, done = false;
		String response = null;
		try {
			channel.register(sel, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
			while (!done) {
				sel.select();
				Iterator it = sel.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					it.remove();
					if (key.isReadable() && !read) {
						if (channel.read(buffer) > 0)
							read = true;
						CharBuffer cb = MutliJabberServerUsingThreadPool.CS.decode((ByteBuffer) buffer.flip());
						response = cb.toString();
					}
					if (key.isWritable() && read) {
						System.out.print("Echoing : " + response);
						channel.write((ByteBuffer) buffer.rewind());
						if (response.indexOf("END") != -1)
							done = true;
						buffer.clear();
						read = false;
					}
				}
			}
		} catch (IOException e) {
			// will be caught by Worker.java and logged.
			// Need to throw runtime exception since we cannot
			// keep it as IOException
			throw new RuntimeException(e);
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				System.out.println("Channel not closed.");
				// Throw it so that worker thread can log it.
				throw new RuntimeException(e);
			}
		}
	}
}

public class MutliJabberServerUsingThreadPool {

	public static final int PORT = 8080;
	private static String encoding = System.getProperty("file.encoding");
	public static final Charset CS = Charset.forName(encoding);
	// Make thread pool with 20 Worker threads.
	private static ThreadPool pool = new ThreadPool(20);

	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		Selector sel = Selector.open();
		try {
			ssc.configureBlocking(false);
			ssc.socket().bind(new InetSocketAddress(PORT));
			SelectionKey key = ssc.register(sel, SelectionKey.OP_ACCEPT);
			System.out.println("Server on port: " + PORT);
			while (true) {
				sel.select();
				Iterator it = sel.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey skey = (SelectionKey) it.next();
					it.remove();
					if (skey.isAcceptable()) {
						SocketChannel channel = ssc.accept();
						System.out.println("Accepted connection from:" + channel.socket());
						channel.configureBlocking(false);
						// Decouple event and associated action
						pool.addTask(new ServeOneJabber(channel));
					}
				}
			}
		} finally {
			ssc.close();
			sel.close();
		}
	}
	
	

}
