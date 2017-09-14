package com.zen.autumn.learn.designPattern.decorator.realcase;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) throws FileNotFoundException {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		return c == -1 ? c : Character.toLowerCase((char) c);
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return super.read(b, off, len);
	}

	public static void main(String[] args) {
		InputStream in = null;
		int c;
		try {
			try {
				in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:/Users/wuliang07/Desktop/11.txt")));
				while ((c = in.read()) >= 0) {
					System.out.print((char) c);
				}
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
