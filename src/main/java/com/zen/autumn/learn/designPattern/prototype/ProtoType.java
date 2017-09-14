package com.zen.autumn.learn.designPattern.prototype;

public abstract class ProtoType {
	
	
	private String id;
	
	public ProtoType(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public abstract ProtoType clone();

}
