package com.zen.autumn.learn.concurrency;

public class VolatileDemo {

	private volatile int i;

	private int j;

	public void set() {
		j = 1;
		i = 2;
	}

	public int get() {
		if (i == 2) {
			return j;
		} else {
			return 0;
		}
	}
	
	
	static void vo(boolean before) throws InterruptedException
	{
		VolatileDemo vd = new VolatileDemo();
		Thread writer = new Thread(){
			@Override
			public void run() {
				vd.set();
			}
		};
		Thread reader = new Thread(){
			@Override
			public void run() {
				System.out.println(before + " "+vd.get());
			}
		};
		
		if(before){
			writer.start();
			Thread.sleep(300);
			reader.start();
		}else{
			reader.start();
			Thread.sleep(300);
			writer.start();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		for(int i =0;i<10;i++){
			boolean flag = (i%2 ==0);
			vo(flag);
		}
		
		
	}
}
