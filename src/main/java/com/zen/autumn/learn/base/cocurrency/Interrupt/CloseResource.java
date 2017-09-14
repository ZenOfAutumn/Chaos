package com.zen.autumn.learn.base.cocurrency.Interrupt;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {

	public static void main(String[] args) throws Exception {

		ExecutorService exe = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);
		InputStream in = new Socket("127.0.0.1", 8080).getInputStream();
		exe.execute(new IOBlocked(in));
		exe.execute(new IOBlocked(System.in));
		TimeUnit.MILLISECONDS.sleep(100);

		exe.shutdownNow();
		TimeUnit.SECONDS.sleep(1);

		System.err.println("closing: " + in.getClass().getName());
		in.close();
		TimeUnit.SECONDS.sleep(1);
		System.err.println("closing: " + System.in.getClass().getName());
		System.in.close();

	}

}
