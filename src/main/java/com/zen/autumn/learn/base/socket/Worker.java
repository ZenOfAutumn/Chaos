package com.zen.autumn.learn.base.socket;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Worker extends Thread {

	public static final Logger LOG = Logger.getLogger("Worker");

	private String workerId;

	private Runnable task;

	private ThreadPool threadPool;

	static {
		try {
			LOG.setUseParentHandlers(false);
			FileHandler ferr = new FileHandler("WorkerErr.log");
			ferr.setFormatter(new SimpleFormatter());
			LOG.addHandler(ferr);
		} catch (IOException e) {
			System.out.println("Logger not initialized..");
		}
	}

	public Worker(String id, ThreadPool pool) {
		workerId = id;
		threadPool = pool;
		start();
	}

	// ThreadPool when schedules a task uses this method
	// to delegate task to a Worker thread. In addition to setting
	// the task (of type Runnable) it also triggers the waiting
	// run() method to start executing the task.
	public void setTask(Runnable t) {
		task = t;
		synchronized (this) {
			notify();
		}
	}

	public void run() {
		try {
			while (!threadPool.isStopped()) {
				synchronized (this) {
					if (task != null) {
						try {
							task.run(); // run the task
						} catch (Exception e) {
							LOG.log(Level.SEVERE, "Exception in source Runnable task", e);
						}
						// return itself to threadpool
						threadPool.putWorker(this);
					}
					wait();
				}
			}
			System.out.println(this + " Stopped");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public String toString() {
		return "Worker : " + workerId;
	}

}
