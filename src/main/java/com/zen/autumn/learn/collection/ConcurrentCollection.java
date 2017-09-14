package com.zen.autumn.learn.collection;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollection {
	
	
	static void COWList(){
		CopyOnWriteArrayList<String> COWList = new CopyOnWriteArrayList<String>();
		
		Runnable modify = new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(i<10){
					COWList.add(String.valueOf(i));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i++;
				}
				
			}
		};
		
		
		Runnable iter = new Runnable() {
			
			@Override
			public void run() {
				while(true){
					System.out.println(COWList);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t = new Thread(modify);
		Thread t1 = new Thread(iter);
		t.start();
		t1.start();
					
	}
	
	
	
	
	public static void main(String[] args) {
		
		COWList();
	}
	
	
	
	

}
