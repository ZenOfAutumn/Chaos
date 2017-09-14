package com.zen.autumn.learn.concurrency;

public class SynchronizedInstanceDemo {

	static class Obj {
		private int i;

		private int j;

		public synchronized int getI() {
			return i;
		}

		public synchronized void setI(int i) throws InterruptedException {
			Thread.sleep(3000);
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public synchronized void setJ(int j) throws InterruptedException {
			Thread.sleep(300);
			this.j = j;
		}
		
		public static void staticM(){
			System.out.println("static");
		}

	}

	static void synInstance() {

		final Obj obj = new Obj();

		Runnable reader = new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println(obj.getI());
					System.out.println("reader finish");
					Thread.yield();
				}
			}
		};

		Runnable writer = new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						obj.setI(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("writer finish");
				}
			}
		};
		
		
		Runnable  read = new Runnable() {
			
			@Override
			public void run() {
				while(true){
					System.out.println(obj.getJ());
				}
			}
		};
		
		Thread staticT = new Thread(){
			
			@Override
			public void run() {
				while(true){
				Obj.staticM();
				}
			}
		};
	
		
		Thread t= new Thread(writer);
		t.start();
		
		Thread t1 = new Thread(reader);
		t1.start();
		
		Thread t3 = new Thread(read);
		t3.start();
		
		staticT.start();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		synInstance();
	}
	

}
