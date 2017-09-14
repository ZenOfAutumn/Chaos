package com.zen.autumn.learn;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {

	
	static <K, V> void print(Map<K, V> map){
		
		for(Map.Entry<K, V> entry:map.entrySet()){
			System.out.print(entry.getKey()+":"+entry.getValue()+" ");
		}
		
		
	}
	
	static void LinkedHashMapTest(){
		
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer,String>(16,0.75f,true);
		for(int i = 0;i<10;i++){
			map.put(i, String.valueOf(i+"11"));
		}
		
		print(map);
		
		System.out.println();
		
		for(int i = 0;i<6;i++){

			map.get(i);
		}
		
		print(map);
		
		
		
	}
	
	
	public static void main(String[] args) {
		LinkedHashMapTest();
	}
}
