package com.zen.autumn.learn.base.collection;

import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

public class LinkedHashMapCase {
	
	
	
	public void testMap(Map map){
		map.put("a", 1L);
		map.put("b", 2L);
		System.err.println(Joiner.on("#").withKeyValueSeparator("=").join(map));

		map.get("a");
		System.err.println(Joiner.on("#").withKeyValueSeparator("=").join(map));

		map.put("c", 3L);
		System.err.println(Joiner.on("#").withKeyValueSeparator("=").join(map));



	}
	
	
	
	public void LRU(){
		
		testMap(Maps.newLinkedHashMapWithExpectedSize(2));
		
	
			
	}

}
