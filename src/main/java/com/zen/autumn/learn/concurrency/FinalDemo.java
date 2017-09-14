package com.zen.autumn.learn.concurrency;

public class FinalDemo {

	int i;
	final int j;
	static FinalDemo obj;

	public FinalDemo() {
		i = 1;
		j = 2;
	}

	public static void writer() {
		obj = new FinalDemo();
	}

	public static void reader() {
		FinalDemo f = obj;
		int a = f.i;
		int b = f.j;
	}

	public static void main(String[] args) throws InterruptedException {

		Thread reader = new Thread() {
			@Override
			public void run() {
				int i = 0;
				while (i<10) {
					if (FinalDemo.obj != null) {
						System.out.println(FinalDemo.obj.i + " " + FinalDemo.obj.j);
					}else{
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					i++;
				}
			}
		};
		
		reader.start();
		
		Thread.sleep(123);
		FinalDemo.writer();

	}

}
