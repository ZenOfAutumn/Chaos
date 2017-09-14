package com.zen.autumn.learn.httpclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpClientTest {
	
	
	
	public static void main(String[] args) throws HttpException, IOException {
		

		HttpClient httpClient = new HttpClient();
		
		
		GetMethod getMethod = new GetMethod("http://www.sse.com.cn/disclosure/listedinfo/announcement/c/2011-03-30/600000_2010_n.pdf");
		
		httpClient.executeMethod(getMethod);
		

		System.err.println(getMethod.getStatusCode());
		System.err.println(getMethod.getStatusText());

		InputStream in = getMethod.getResponseBodyAsStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/wuliang07/Desktop/1.pdf")));

		
		int dd =  -1;
		while((dd = reader.read())!=-1){
			System.err.println(dd);
			w.write(dd);
		}
		
		reader.close();
		w.close();
		
	}

}
