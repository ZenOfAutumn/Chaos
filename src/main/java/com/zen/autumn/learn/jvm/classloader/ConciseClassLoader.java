package com.zen.autumn.learn.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;


class LoaderClass {
	
	private String name;
	
	private int age;
	
	
	
}

public class ConciseClassLoader extends ClassLoader{
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException{
		
		try{
			String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
			
			System.out.println(fileName);
			
			InputStream in = getClass().getResourceAsStream(fileName);
			
			if(in == null){
 
				return super.loadClass(fileName);
			}
			
			byte[] b = new byte[in.available()];
			in.read(b);
			return defineClass(name, b, 0,b.length);
			
			
			
		}catch(IOException e){
			throw new ClassNotFoundException(name);
	    }	
		
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		
		ClassLoader loader = new ConciseClassLoader();
		
		Class<?> loadClass = loader.loadClass("com.zen.autumn.learn.jvm.classloader.LoaderClass");
		
		System.out.println(loadClass.getName());

		Object instance = loadClass.newInstance();
		
		System.out.println(instance instanceof com.zen.autumn.learn.jvm.classloader.ConciseClassLoader);
		
	}

}
