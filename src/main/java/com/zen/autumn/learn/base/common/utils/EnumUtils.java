package com.zen.autumn.learn.base.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

enum NonEnumPlay implements EnumId<String, NonEnumPlay>{

	A("Hello");
	
	private String id;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public NonEnumPlay[] getValues() {
		return values();
	}
	
	
	 NonEnumPlay(final String id) {
		 this.id = id;
	 }
}

public final class EnumUtils {
	
	private EnumUtils() throws IllegalAccessException{
		throw new IllegalAccessException();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T, E extends Enum & EnumId > Map<T, E> getEnumMap(final Class<E> enumClass) throws InstantiationException, IllegalAccessException {
		Map<T, E> map = new LinkedHashMap<T, E>();			
		for (EnumId e : enumClass.getEnumConstants()[0].getValues()) {		
			map.put((T)e.getId(), (E)e);
		}
		return map;
	}
	
	
	

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println(EnumUtils.getEnumMap(EnumExample.class));
		
		System.out.println(EnumUtils.getEnumMap(NonEnumPlay.class));
		
		
	}
	
	
	

}
