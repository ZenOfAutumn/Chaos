package com.zen.autumn.learn.base.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class Dirfilter implements FilenameFilter{
	private Pattern pattern;
	
	public Dirfilter(String regex){
		pattern = Pattern.compile(regex);
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}

public class DirList {
	
	
	public static void main(String[] args) {
		File path = new File(".");
		
		String[] list;
		list = path.list();
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(list));
		
	}
	

}
