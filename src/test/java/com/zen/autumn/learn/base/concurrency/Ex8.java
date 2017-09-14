package com.zen.autumn.learn.base.concurrency;

import java.util.concurrent.TimeUnit;

class SimpleThread extends Thread {
	  private int countDown = 5;
	  private static int threadCount = 0;
	  public SimpleThread() {
	    super(Integer.toString(++threadCount));
	    this.setDaemon(true);
	    start();
	  }
	  public String toString() {
	    return "#" + getName() + "(" + countDown + "), ";
	  }
	  
	  @Override
	  public void run() {
	    while(true) {
	      System.out.print(this);
	      try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      if(--countDown == 0)
	        return;
	    }
	  }
 }
public class Ex8 {
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++)
		      new SimpleThread();
	}
}


