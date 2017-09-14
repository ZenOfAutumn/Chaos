package com.zen.autumn.learn;

public class BeanEqualTest {

	public static void main(String[] args) {

//		ExecutorService exe = Executors.newFixedThreadPool(10);
//
//		for (int i = 0; i < 10; i++) {
//
//			exe.execute(new Runnable() {
//				
//				
//				public void run() {
//
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				}
//			});
//		}
		

		Thread t = new Thread(new Runnable() {
			
			public void run() {

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("11");
			}
		});
		
		t.start();
		System.err.println(t.isAlive());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.err.println(t.isAlive());
		
	}

}
