package com.zen.autumn.learn.concurrency;

public class FinalReferenceEscapeDemo {

	final int i;

	static FinalReferenceEscapeDemo obj;

	public FinalReferenceEscapeDemo() {
		i = 1;
		obj = this;
	}

	static void w() {
		new FinalReferenceEscapeDemo();
	}

	static void r() {
		if (obj != null) {
			System.out.println(obj.i);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread r = new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						FinalReferenceEscapeDemo.r();
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};

		Thread w = new Thread() {
			public void run() {
				FinalReferenceEscapeDemo.w();
			};
		};

		r.start();
		Thread.sleep(20);
		w.start();

	}

}
