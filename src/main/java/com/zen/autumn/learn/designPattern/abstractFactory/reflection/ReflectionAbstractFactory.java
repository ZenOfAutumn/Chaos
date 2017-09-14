package com.zen.autumn.learn.designPattern.abstractFactory.reflection;

import com.zen.autumn.learn.designPattern.abstractFactory.AbstractProductA;
import com.zen.autumn.learn.designPattern.abstractFactory.AbstractProductB;

public class ReflectionAbstractFactory {
	
	
	
	static AbstractProductA createProductA(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{	
		return (AbstractProductA)Class.forName(className).newInstance();	
	}
	
	static AbstractProductB createProductB(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (AbstractProductB)Class.forName(className).newInstance();
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T createInstance(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (T) Class.forName(className).newInstance();
	}
	
	public static void main(String[] args) {
			
		try {
			AbstractProductA  AbA = createProductA("com.zen.autumn.learn.designPattern.abstractFactory.ConcreteProductAA");
			AbA.insert();

			AbstractProductB AbB = createInstance("com.zen.autumn.learn.designPattern.abstractFactory.ConcreteProductBA");
			AbB.select();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
