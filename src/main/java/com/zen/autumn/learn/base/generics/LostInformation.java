package com.zen.autumn.learn.base.generics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;



class Quark<Q>{
	
}

public class LostInformation {
	
	public static void main(String[] args) {
		
		List<Long> longList =  Lists.newArrayList();
		
		Map<String,Long> mapMap = Maps.newHashMap();
		
		Quark<Integer> quark =  new Quark<Integer>();
		
		System.out.println(Arrays.toString(longList.getClass().getTypeParameters()));
		
		System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
		
		System.out.println(Arrays.toString(mapMap.getClass().getTypeParameters()));	
		
	}

}
