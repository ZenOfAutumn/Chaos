package com.zen.autumn.learn.base.cocurrency.Sychronized;

class SynchronizedClassTaskF implements Runnable{
	
	private SynchronizedClass  instance;
	
	public void setSynchronizedClass(SynchronizedClass instance){
		this.instance = instance;
	}
	
	@Override
	public void run() {
		try{
			instance.f();
		}catch(InterruptedException e){
			e.printStackTrace();
		}		
	}	
	
}

class SynchronizedClassTaskG implements Runnable{
	
	private SynchronizedClass  instance;
	
	public void setSynchronizedClass(SynchronizedClass instance){
		this.instance = instance;
	}
	
	@Override
	public void run() {
		instance.g();	
	}	
	
}




public class SynchronizedClassUseCase {
	
	public static void main(String[] args) {
		
		SynchronizedClass synchronizedClass = new SynchronizedClass();
		
		SynchronizedClassTaskF taskF = new SynchronizedClassTaskF();
		taskF.setSynchronizedClass(synchronizedClass);
		
		SynchronizedClassTaskG taskG = new SynchronizedClassTaskG();
		taskG.setSynchronizedClass(synchronizedClass);
		
		Thread ft = new Thread(taskF);
		ft.start();
		
		Thread gt = new Thread(taskG);
		gt.start();
		
	}

}
