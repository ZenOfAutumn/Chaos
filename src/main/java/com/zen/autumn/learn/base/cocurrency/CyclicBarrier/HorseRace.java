package com.zen.autumn.learn.base.cocurrency.CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Horse implements Runnable{
	
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static final Random rand = new Random(47);
	private static CyclicBarrier barrier;
	@SuppressWarnings("static-access")
	public Horse(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	public synchronized int getStrides(){
		return strides;
	}	
	
	
	@Override
	public void run() {
		try{
			while(!Thread.interrupted()){
				synchronized (this) {
					strides += rand.nextInt(3);
				}
				barrier.await();		

			}
		}catch(InterruptedException e){
			
		}catch(BrokenBarrierException e){
			throw new RuntimeException(e);
			
		}
		
	}
	
	@Override
	public String toString() {
		return "Horse" + id;
	}
	
	public String tracks(){
		StringBuilder str = new StringBuilder();
		for(int i=0;i<getStrides();i++){
			str.append("*");
		}
		str.append(id);
		return str.toString();
	}
	
}


public class HorseRace {
	static final int FINISH_LINE = 10;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService exe = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	
	public HorseRace(int nHorses,final int pause) {
		barrier = new CyclicBarrier(nHorses,new Runnable() {
			
			@Override
			public void run() {
				StringBuilder str = new StringBuilder();
				for(int i=0;i<FINISH_LINE;i++){
					str.append("=");
				}
				System.out.println(str);
				
				for(Horse horse:horses){
					System.out.println("horse" + horse.tracks());
				}
				
				for(Horse horse:horses){
					if(horse.getStrides()>=FINISH_LINE){
						System.out.println(horse + "won");
						exe.shutdownNow();
						return;
					}
				}
				
			
			try{
				TimeUnit.MILLISECONDS.sleep(pause);				
			}catch(InterruptedException e){
				System.out.println("barrier interrupted");
			}
			}
			
		});		
		
		for(int i = 0;i<nHorses;i++){
			Horse horse = new Horse(barrier);
			horses.add(horse);
			exe.execute(horse);			
		}
	}
	
	public static void main(String[] args) {
		int nHorses = 7;
		int pause = 200;
		new HorseRace(nHorses, pause);
		
	}
	
	
	

}
