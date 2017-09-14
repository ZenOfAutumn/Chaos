package com.zen.autumn.learn.base.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import com.google.common.base.Charsets;

public class PostCase {
	
	
	static String filePath = "./post.properties";
	
	public static String doPost(String urlString,Map<Object,Object> KV) throws IOException{
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);
		
		try(PrintWriter writer = new PrintWriter(connection.getOutputStream())){
			
			boolean first = true;
			for(Map.Entry<Object, Object> entry:KV.entrySet()){
				if(first) {first = false;}else{writer.print('&');
				
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				writer.print(key);
				writer.print('=');
				writer.print(URLEncoder.encode(value,Charsets.UTF_8.name()));		
				
				}			
			}
			
			StringBuilder builder =new StringBuilder();
			try(Scanner in = new Scanner(connection.getInputStream())){
				while(in.hasNextLine()){
					builder.append(in).append('\n');
				}
				
			}catch(IOException e){
				
				if(!(connection instanceof HttpURLConnection)) throw e;
				InputStream err = ((HttpURLConnection)connection).getErrorStream();
				if(err == null)throw e;
				Scanner in = new Scanner(err);
				builder.append(in.nextLine());
				builder.append('\n');				
				
			}		
			
			return builder.toString();
			
			
		}		
		
	}
	
	
	
	
	public static void main(String[] args) {
		Properties props = new Properties();
		try(InputStream in =Files.newInputStream(Paths.get(filePath))){
			props.load(in);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String name:props.stringPropertyNames()){
			System.out.println(name+":"+props.getProperty(name));
		}
		
		
		String url = props.remove("url").toString();
		try {
			System.out.println(doPost(url, props));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
