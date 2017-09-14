package com.zen.autumn.learn.base.cocurrency;

public class SelfManagedTasK implements Runnable {

	int count = 5;
	
	private Thread t = new Thread(this);
	
	public SelfManagedTasK(){t.start();}
	
	
	
	@Override
	public String toString() {
		return "SelfManagedTasK [count=" + count + ", t=" + Thread.currentThread().getName() + "]";
	}



	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if(--count == 0){
				return ;
			}
		}

	}
	
	public static void main(String[] args) {
		for(int i = 0;i<10;i++){
			new SelfManagedTasK();
		}
		
		
		
	}

}
