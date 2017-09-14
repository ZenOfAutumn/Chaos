package com.zen.autumn.learn.base.enums;

import java.util.EnumMap;
import java.util.Map;

public interface Command {
	
	void action();
	

	public static void main(String[] args) {
		EnumMap<Alpha,Command> em = new EnumMap<Alpha,Command>(Alpha.class);
		
		em.put(Alpha.A, new Command() {
			
			@Override
			public void action() {

				System.out.println("A");
			}
		});
		
		for(Map.Entry<Alpha, Command> entry:em.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
			entry.getValue().action();
		}
	}

}

enum Alpha{
	A,B,C;
}


