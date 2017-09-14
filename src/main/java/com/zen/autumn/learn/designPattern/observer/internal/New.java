package com.zen.autumn.learn.designPattern.observer.internal;

import java.util.Observable;

public class New extends Observable {
	
	
	private String newContent;
	
	public New(String newContente) {
	
		this.newContent = newContente;
		// TODO Auto-generated constructor stub
	}
	
	
	public String getNews(){
		return newContent;
	}
	
	
	public void setNews(String news){
		this.newContent = news;
		setChanged();
		notifyObservers(this);
	}
	
}
