package com.zen.autumn.learn.crawl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TencentHttpPostParamString {

	public static String PARAM_STRING = "";
	
	static {

		try {
			init();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void init() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./resources/tencentParamsString.properties")), "utf-8"));
		
		PARAM_STRING = reader.readLine();
		
		reader.close();
		
		
	}

}
