package com.zen.autumn.learn.base.process.basecase;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalledProcess {

	public static void main(String[] args) throws IOException {
		Runtime run = Runtime.getRuntime();
		System.out.println(run.totalMemory());
		Process process = run.exec("java com.zen.autumn.learn.base.process.basecase.BeCalledProcess");
		BufferedInputStream bu = new BufferedInputStream(process.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(bu));
		String s;
		while ((s = br.readLine()) != null)
			System.out.println(s);
	}

}
