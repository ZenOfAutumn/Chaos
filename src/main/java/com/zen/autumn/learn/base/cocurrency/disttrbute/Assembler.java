package com.zen.autumn.learn.base.cocurrency.disttrbute;

import java.util.concurrent.CyclicBarrier;

public class Assembler implements Runnable {

	private CarQueue chassisQueue;
	
	private CarQueue finishingQueue;
	
	private Car car;
	
	private CyclicBarrier barrier = new CyclicBarrier(4);
	
//	private RobotPool robotPool;
	
//	public Assembler(CarQueue cq,CarQueue fq,RobotPool rp) {
//		this.chassisQueue = cq;
//		this.finishingQueue = fq;
////		this.robotPool = rp;
//	}
	
	public Car car(){
		return car;
	}
	
	
	 
	
	
	@Override
	public void run() {
		
	}

}
