package com.zen.autumn.learn.base.cocurrency.ReadWriterLock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterLockList<T> {
	
	private ArrayList<T> lockedList;
		
	private  ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	public ReadWriterLockList(int size,T element) {

		lockedList = new ArrayList<T>(Collections.nCopies(size, element));
	
	}
	
	
	public T set(int index,T element){
		Lock wlock = lock.writeLock();
		wlock.lock();
		try{
			return lockedList.set(index, element);
		}finally{
			wlock.unlock();
		}		
	}
	
	
	
	
	public T get(int index){
		Lock rlock =lock.readLock();
		rlock.lock();
		try{
			if(lock.getReadHoldCount()>1){
				System.out.println(lock.getReadLockCount());
			}
			return lockedList.get(index);
		}finally{
			rlock.unlock();
		}
		
	}
	
	
	

}
