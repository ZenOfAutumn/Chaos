package com.zen.autumn.learn.base.innerclass.localinnerclass;

import java.util.ArrayList;
import java.util.List;

public class LocalInnerClass {
	
	public static List<Fly> getAllFlyGesture(){
		List<Fly> flyArray = new ArrayList<Fly>();
		
		class LocalFly implements Fly{

			private int LocalFlyId;	
					
			public int getLocalFlyId() {
				return LocalFlyId;
			}

			public LocalFly setLocalFlyId(int localFlyId) {
				LocalFlyId = localFlyId;
				return this;
			}

			@Override
			public void gesture() {
				System.out.println("Local fly id:"+LocalFlyId);			
			}
			
		}
		
		flyArray.add(new LocalFly().setLocalFlyId(1));
		flyArray.add(new LocalFly().setLocalFlyId(2));
		
		return flyArray;
			
		
		
	}
	
	public static void main(String[] args){
		
		for(Fly fly: getAllFlyGesture()){
			fly.gesture();
		}
		
	}
	
	

}
