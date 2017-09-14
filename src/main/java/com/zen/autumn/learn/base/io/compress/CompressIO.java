package com.zen.autumn.learn.base.io.compress;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

public class CompressIO {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		BufferedOutputStream output = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(".gz")));

		BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(".gz"))));
	
		BufferedOutputStream zip = new BufferedOutputStream(new ZipOutputStream(new CheckedOutputStream(new FileOutputStream(""), new CRC32())));
		
		
	
	}
}
