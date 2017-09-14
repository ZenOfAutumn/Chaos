package com.zen.autumn.learn.base.socket;

import java.util.Iterator;
import java.util.LinkedList;

public class ThreadPool  extends Thread{

	private static final int DEFAULT_NUM_WORKERS = 5;
	private LinkedList workerPool = new LinkedList(), taskList = new LinkedList();
	private boolean stopped = false;

	public ThreadPool() {
		this(DEFAULT_NUM_WORKERS);
	}

	public ThreadPool(int numOfWorkers) {
		for (int i = 0; i < numOfWorkers; i++)
			workerPool.add(new Worker("" + i, this));
		start();
	}

	public void run() {
		try {
			while (!stopped) {
				if (taskList.isEmpty()) {
					synchronized (taskList) {
						// If queue is empty, wait for tasks to be added
						taskList.wait();
					}
				} else if (workerPool.isEmpty()) {
					synchronized (workerPool) {
						// If no worker threads available, wait till
						// one is available
						workerPool.wait();
					}
				}
				// Run the next task from the tasks scheduled
				getWorker().setTask((Runnable) taskList.removeLast());
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void addTask(Runnable task) {
		taskList.addFirst(task);
		synchronized (taskList) {
			taskList.notify(); // If new task added, notify
		}
	}

	public void putWorker(Worker worker) {
		workerPool.addFirst(worker);
		// There may be cases when you have a pool of 5 threads
		// and the requirement exceeds this. That is when a Worker is required
		// but none is available (or free), it just blocks on threadpool.
		// This is the event that there is now a free Worker thread in
		// threadpool. Hence this thread does a notification that unblocks
		// the ThreadPool thread waiting on threadpool
		synchronized (workerPool) {
			workerPool.notify();
		}
	}

	private Worker getWorker() {
		return (Worker) workerPool.removeLast();
	}

	public boolean isStopped() {
		return stopped;
	}

	public void stopThreads() {
		stopped = true;
		Iterator it = workerPool.iterator();
		while (it.hasNext()) {
			Worker w = (Worker) it.next();
			synchronized (w) {
				w.notify();
			}
		}
	} // Junit test

	public void testThreadPool() {
		ThreadPool tp = new ThreadPool();
		for (int i = 0; i < 10; i++) {
			tp.addTask(new Runnable() {
				public void run() {
					System.out.println("A");
				}
			});
		}
		tp.stopThreads();
	}
}
