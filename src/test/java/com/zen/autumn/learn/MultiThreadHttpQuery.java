package com.zen.autumn.learn;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.common.collect.Sets;

class Get implements Runnable {

	public static ConcurrentLinkedQueue<String> resultQueue = new ConcurrentLinkedQueue<String>();

	public void run() {

		HttpClient httpClient = new HttpClient();

		GetMethod getMethod = new GetMethod("http://10.100.123.50:8080/getDeviceIdByIP?ip=xxx.xxx.xx.xx");

		try {
			httpClient.executeMethod(getMethod);

			String result = getMethod.getResponseBodyAsString();

			resultQueue.add(result);
			System.err.println(result);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

public class MultiThreadHttpQuery {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			executorService.execute(new Get());
		}

		Thread.sleep(30000);
		System.err.println("start exam data");

		System.err.println(Get.resultQueue.size());

		Set<String> hello = Sets.newHashSet();

		for (String str : Get.resultQueue) {
			hello.add(str);

		}

		System.err.println(hello.size());

	}

}
