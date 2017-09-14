package com.zen.autumn.learn.concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {

	static ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<Integer>();

	static class Queue {

		public Node head;
		public Node tail;

	}

	static class Node {

		public Object i;
		public Node next;
	}

	static void fairQueue() {

		Queue q = new Queue();
		q.head = new Node();
		Node p = q.head;
		q.head = null;
		System.out.println(p);

	}
	
	
	static void clq(){
		while(true){
			if(!Thread.currentThread().isInterrupted()){
				for(int i = 0;i<10;i++){
				clq.add(i);
				}
			}else{
				System.out.println(Thread.currentThread().getName() + " has interrupt.");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " has end.");

	}

	static void clqPutThread() {

		ThreadGroup tg = new ThreadGroup("clqPutThread");

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(tg, new Runnable() {
				@Override
				public void run() {
					clq();
				}
			});
			t.start();
		}

		try {
			Thread.sleep(10);
			tg.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	static void clqTakeThread() {

		ThreadGroup tg = new ThreadGroup("clqTakeThread");

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(tg, new Runnable() {
				@Override
				public void run() {
					while (clq.peek() != null) {
						System.out.println(clq.size());
						System.out.println(Thread.currentThread().getThreadGroup().getName() +Thread.currentThread().getName() + " " + clq.poll());
					}
				}
			});
			t.start();
		}

		try {
			Thread.sleep(3000);
			tg.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		clqPutThread();
		clqTakeThread();
	}

}
