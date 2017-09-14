package com.zen.autumn.learn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class CompanyNameCleanUtils {

	private static final Logger LOG = Logger.getLogger(CompanyNameCleanUtils.class);

	public CompanyNameCleanUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

	public static String clean(String companyName) {
		String preCompany = companyName.replaceAll(Symbol.ESCAPE_ENGLISH_LEFT_BRACKET, Symbol.CHINESE_LEFT_BRACKET)
				.replaceAll(Symbol.ESCAPE_ENGLISH_RIGHT_BRACKET, Symbol.CHINESE_RIGHT_BRACKET).trim();
		Pattern pattern = Pattern.compile(CharsetCollection.COMPANY_NAME_REGEX);
		Matcher m = pattern.matcher(preCompany);
		while (m.find()) {
			return m.group();
		}

		System.err.println("illegal company name: " + preCompany);
		throw new RuntimeException();

	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(args[0])), "utf-8"));
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1])), "utf-8"));

		String s;
		
		while((s = reader.readLine())!=null){
			String n = clean(s);
			
			if(n.contains(Symbol.CHINESE_LEFT_BRACKET)||n.contains(Symbol.CHINESE_RIGHT_BRACKET)){
				System.err.println(n);
				String p  = n.replaceAll(Symbol.CHINESE_LEFT_BRACKET, Symbol.ESCAPE_ENGLISH_LEFT_BRACKET)
						.replaceAll(Symbol.CHINESE_RIGHT_BRACKET, Symbol.ESCAPE_ENGLISH_RIGHT_BRACKET);
				w.write(p);
				w.newLine();
			}
			
			w.write(n);
			w.newLine();
		}
		
		reader.close();
		w.close();
		
	}

}
