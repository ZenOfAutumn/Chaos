package com.zen.autumn.learn.designPattern.observer.self;


public interface Subject {

		public void registerObserver(Observer o);
		
		public void removeObserver(Observer o);
		
		public void notifyObservers();
}
