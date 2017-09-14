package com.zen.autumn.learn.base.io;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public final class Directory {
	
	public static File[] local(File dir){
		return dir.listFiles();
	}
	
	
	public static TreeInfo recurseInfo(File startDir){
		
		TreeInfo result = new TreeInfo();
		for(File item:startDir.listFiles()){
			if(item.isDirectory()){
				result.getDirs().add(item);
				result.addAll(recurseInfo(item));
			}else{
				result.getFiles().add(item);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeInfo info = recurseInfo(new File("."));
		System.out.println("FILE:");
		for(File file:info.getFiles()){
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("PATH:");
		for(File dir:info.getDirs()){
			System.out.println(dir.getAbsolutePath());
		}
		
		
		
	}
	
	
	public static class TreeInfo implements Iterable<File>{
		
		private List<File> files = Lists.newArrayList();
		private List<File> dirs = Lists.newArrayList();	
		

		public List<File> getFiles() {
			return files;
		}

		public List<File> getDirs() {
			return dirs;
		}

		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		void addAll(TreeInfo other){
			files.addAll(other.getFiles());
			dirs.addAll(other.getDirs());
		}

		
		
		
	}
	
	
	
}
