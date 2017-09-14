package com.zen.autumn.learn.base.reflect.enums;

import java.util.Map;

import com.google.common.collect.Maps;

public enum Type implements FieldTransferHandle<Type,Byte> {
	
	COMEDY((byte)1,"喜剧"),
	
	TRAGEDY((byte)2,"悲剧")	
	
	;

	private Byte id;
	
	private String name;
	
	
	
	public byte getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}


	private static final Map<Byte,Type> TYPE_MAP = Maps.newHashMap();
     
	
	Type(){
		
	}
	
	private Type(byte id,String name) {
		this.id = id;
		this.name= name;
		
		// TODO Auto-generated constructor stub
	}
	
	private static  void init(){
		for(Type item:Type.values()){
			TYPE_MAP.put(item.getId(), item);
		}
	}
	
	static{
		init();
	}
	
	@Override
	public Type getEnumById(final Byte id) {
		return TYPE_MAP.get(id);
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			Type.class.getDeclaredField("id");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
