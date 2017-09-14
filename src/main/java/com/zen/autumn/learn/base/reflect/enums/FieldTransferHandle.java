package com.zen.autumn.learn.base.reflect.enums;

@SuppressWarnings("rawtypes")
public interface FieldTransferHandle<E extends FieldTransferHandle,T> {
	
	public static final String ID = "id";	
	
	E getEnumById(T id);
	
	String getName();
	
	

}
