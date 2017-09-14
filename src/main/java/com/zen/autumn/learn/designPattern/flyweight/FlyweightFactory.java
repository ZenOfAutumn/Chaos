package com.zen.autumn.learn.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	
	
	private Map<String,Flyweight> flyweights = new HashMap<String,Flyweight>();
	public FlyweightFactory() {
		flyweights.put("A",new ConcreteFlyWeight());
		flyweights.put("X",new ConcreteFlyWeight());
		flyweights.put("Y",new ConcreteFlyWeight());

	}
	
	
	public Flyweight getFlyweight(String Key){
		return flyweights.get(Key);
	}

}
